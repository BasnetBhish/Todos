package com.example.todos.exception;

import com.example.todos.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(TaskNotFoundException.class)
    protected ResponseEntity<ErrorDto> handleTaskNotFoundException(TaskNotFoundException e) {
        ErrorDto dto = new ErrorDto();
        dto.setMessage(e.getMessage());
        dto.setErrorCode("404");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
