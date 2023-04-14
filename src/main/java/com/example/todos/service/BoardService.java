package com.example.todos.service;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.exception.TaskNotFoundException;
import com.example.todos.model.BoardResponseModel;

import java.util.List;

public interface BoardService {

    BoardResponseModel getBoardTasks(String boardName) throws TaskNotFoundException;

    List<Task> getUserTask(String boardName, String assignee);

    List<Task> getTaskByStatus(String boardName, Status status);
}
