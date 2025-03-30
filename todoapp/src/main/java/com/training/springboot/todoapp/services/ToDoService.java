package com.training.springboot.todoapp.services;

import com.training.springboot.todoapp.models.ToDoItem;
import com.training.springboot.todoapp.repositories.InMemRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final InMemRepo inMemRepo;

    public ToDoService(InMemRepo inMemRepo) {
        this.inMemRepo = inMemRepo;
    }


    public List<ToDoItem> getAll(String username) {
        return inMemRepo.getAll(username);
    }

    public Optional<ToDoItem> getById(String username, long id) {
        return inMemRepo.getById(username, id);
    }

//    public List<ToDoItem> getByUsername(String username) {
//        return inMemRepo.getByUsername(username);
//    }

    public boolean add(ToDoItem item) {
        inMemRepo.add(item);
        return true;
    }

    public boolean update(long id, ToDoItem item) {
        inMemRepo.update(id, item);
        return true;
    }

    public boolean delete(long id) {
        inMemRepo.delete(id);
        return true;
    }
}
