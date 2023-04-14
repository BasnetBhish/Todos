package com.example.todos.entities;

import com.example.todos.enums.Status;
import com.example.todos.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String boardName;
    private String description;
    private String authorName;
    private String authorEmail;
    private Status status;
    private Type type;
    private String assignee;

    private Date createdDate;
    private Date modifiedDate;
}
