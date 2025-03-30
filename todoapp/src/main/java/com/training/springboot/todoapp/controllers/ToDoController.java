package com.training.springboot.todoapp.controllers;

import com.training.springboot.todoapp.models.ToDoItem;
import com.training.springboot.todoapp.services.ToDoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "ToDo Service", description = "All services related to ToDo management")
@RestController
@RequestMapping("/todos")
@Slf4j
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        log.info("Calling service");
        this.toDoService = toDoService;
    }

    @GetMapping("/{username}/all")
    public List<ToDoItem> getAll(@PathVariable String username) {
        return toDoService.getAll(username);
    }

    @GetMapping("/{username}/{id}")
    public Optional<ToDoItem> getById(@PathVariable String username, @PathVariable long id) {
        return toDoService.getById(username, id);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody ToDoItem item) {
        return new ResponseEntity<>(toDoService.add(item), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable long id, @RequestBody ToDoItem item) {
        return new ResponseEntity<>(toDoService.update(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        return new ResponseEntity<>(toDoService.delete(id), HttpStatus.OK);
    }

}
