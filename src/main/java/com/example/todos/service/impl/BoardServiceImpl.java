package com.example.todos.service.impl;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.exception.TaskNotFoundException;
import com.example.todos.model.BoardResponseModel;
import com.example.todos.repository.TaskRepository;
import com.example.todos.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public BoardResponseModel getBoardTasks(String boardName) throws TaskNotFoundException {
        List<Task> list = taskRepository.findByBoardName(boardName).orElseThrow(() -> new TaskNotFoundException("Task not found for board name " + boardName));
        Map<String, List<Task>> boardDetails = list.stream().collect(Collectors.groupingBy(task -> task.getStatus().name().toLowerCase()));
        return BoardResponseModel
                .builder()
                .board(boardDetails)
                .build();
    }

    @Override
    public List<Task> getUserTask(String boardName, String assignee) {
        return taskRepository.findByBoardNameAndAssignee(boardName,assignee);
    }

    @Override
    public List<Task> getTaskByStatus(String boardName, Status status) {
        return taskRepository.findByBoardNameAndStatus(boardName,status);
    }
}
