package com.example.todos.controller;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import com.example.todos.exception.TaskNotFoundException;
import com.example.todos.model.BoardResponseModel;
import com.example.todos.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/{boardName}")
    private ResponseEntity<BoardResponseModel> getBoardTasks(@PathVariable String boardName) throws TaskNotFoundException {
        return new ResponseEntity<>(boardService.getBoardTasks(boardName), HttpStatus.OK);
    }

    @GetMapping("/{boardName}/user/{assignee}")
    private ResponseEntity<List<Task>> getUserTasks(@PathVariable String boardName, @PathVariable String assignee) throws TaskNotFoundException {
        return new ResponseEntity<>(boardService.getUserTask(boardName, assignee), HttpStatus.OK);
    }

    @GetMapping("/{boardName}/{status}")
    private ResponseEntity<List<Task>> getUserTasks(@PathVariable String boardName, @PathVariable Status status) throws TaskNotFoundException {
        return new ResponseEntity<>(boardService.getTaskByStatus(boardName, status), HttpStatus.OK);
    }
}
