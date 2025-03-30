package com.training.springboot.todoapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoItem {
    public long id;
    public String title;
    public LocalDate dueDate;
    public boolean completed;

    public String username;
}
