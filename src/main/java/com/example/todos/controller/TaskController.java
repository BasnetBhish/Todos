package com.example.todos.controller;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.exception.TaskNotFoundException;
import com.example.todos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.update(id, task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws TaskNotFoundException {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam Status status) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.updateStatus(id, status), HttpStatus.OK);
    }

    @PatchMapping("/assignee/{id}")
    public ResponseEntity<Task> updateAssignee(@PathVariable Long id, @RequestParam String assignee) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.updateAssignee(id, assignee), HttpStatus.OK);
    }

}
