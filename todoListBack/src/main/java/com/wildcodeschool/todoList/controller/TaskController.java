package com.wildcodeschool.todoList.controller;

import com.wildcodeschool.todoList.entity.Task;
import com.wildcodeschool.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks/")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(this.taskService.findAll());
    }

    @PostMapping("")
    public void save(@RequestBody Task task){
        this.taskService.saveOrUpdate(task);
    }

    @PutMapping("")
    public void updateById(@RequestBody Task task){
        this.taskService.saveOrUpdate(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.taskService.deleteById(id);
    }
}
