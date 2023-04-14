package com.example.todos.repository;

import com.example.todos.entities.Task;
import com.example.todos.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findByBoardNameAndAssignee(String boardName, String assignee);

    List<Task> findByBoardNameAndStatus(String boardName, Status status);

    Optional<List<Task>> findByBoardName(String boardName);
}
