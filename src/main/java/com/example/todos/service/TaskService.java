package com.example.todos.service;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.exception.TaskNotFoundException;

public interface TaskService {

    Task create(Task task);

    Task get(Long id) throws TaskNotFoundException;

    Task update(Long id ,Task task) throws TaskNotFoundException;

    Task updateStatus(Long id, Status status) throws TaskNotFoundException;

    Task updateAssignee(Long id, String assignee) throws TaskNotFoundException;

    void delete(Long id) throws TaskNotFoundException;


}
