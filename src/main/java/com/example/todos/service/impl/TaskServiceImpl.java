package com.example.todos.service.impl;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.enums.Type;
import com.example.todos.exception.TaskNotFoundException;
import com.example.todos.repository.TaskRepository;
import com.example.todos.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        logger.info("Creating a new task");
        task.setCreatedDate(new Date());
        task.setModifiedDate(new Date());
        return taskRepository.save(task);
    }

    @Override
    public Task get(Long id) throws TaskNotFoundException {
        return taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id "+id));
    }

    @Override
    public Task update(Long id, Task task) throws TaskNotFoundException {
        Task existingTask = get(id);
        task.setModifiedDate(new Date());
        task.setCreatedDate(existingTask.getCreatedDate());
        return taskRepository.save(task);
    }

    @Override
    public Task updateStatus(Long id, Status status) throws TaskNotFoundException {
        Task existingTask = get(id);
        existingTask.setStatus(status);
        existingTask.setModifiedDate(new Date());
        return taskRepository.save(existingTask);
    }

    @Override
    public Task updateAssignee(Long id, String assignee) throws TaskNotFoundException {
        Task existingTask = get(id);
        existingTask.setAssignee(assignee);
        existingTask.setModifiedDate(new Date());
        return taskRepository.save(existingTask);
    }

    @Override
    public void delete(Long id) throws TaskNotFoundException {
        Task existingTask = get(id);
        taskRepository.delete(existingTask);
    }



    @PostConstruct
    private void ingestData(){
        logger.info("Ingesting initial data");
        String[] names={"Matt","Leo","Kevin"};
        List<Task> list = IntStream.range(1, 11).boxed().map(i -> dummyTask(i, names[i % 3]))
                .collect(Collectors.toList());
        taskRepository.saveAll(list);
    }

    private Task dummyTask(int i, String name){
        return Task.builder()
                .name("Test Task "+i)
                .authorName(name)
                .authorEmail(name+"@jira.com")
                .assignee(name)
                .boardName("Test Board")
                .createdDate(new Date())
                .modifiedDate(new Date())
                .status(Status.TODO)
                .description("Dummy Task")
                .type(Type.STORY)
                .build();
    }
}
