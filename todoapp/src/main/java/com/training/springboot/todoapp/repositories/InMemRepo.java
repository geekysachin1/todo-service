package com.training.springboot.todoapp.repositories;

import com.training.springboot.todoapp.models.ToDoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemRepo {
    private static List<ToDoItem> toDoItems;

    public InMemRepo() {
        toDoItems = new ArrayList<>();
    }


    public List<ToDoItem> getAll(String username) {
        return toDoItems.stream().filter(x -> x.username.equals(username)).collect(Collectors.toList());
    }

    public Optional<ToDoItem> getById(String username, long id) {
        return toDoItems.stream().filter(x -> x.username.equals(username) && x.id == id).findFirst();
    }

    public void add(ToDoItem item) {
        toDoItems.add(item);
    }

    public void update(long id, ToDoItem item) {
        toDoItems.stream().filter(x -> x.id == id)
                .forEach(td -> {
                    td.completed = item.completed;
                    td.dueDate = item.dueDate;
                    td.title = item.title;
                    td.username = item.username;
                });
    }

    public void delete(long id) {
        toDoItems.stream().filter(x -> x.id == id)
                .forEach(item -> {
                    toDoItems.remove(item);
                });
    }

    public Optional<ToDoItem> getById(long id) {
        return toDoItems.stream().filter(x -> x.id == id).findFirst();
    }
}
