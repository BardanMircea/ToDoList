package com.wildcodeschool.todoList.service;

import com.wildcodeschool.todoList.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Optional<Task> findById(long id);
    List<Task> findAll();
    void saveOrUpdate(Task task);
    void deleteById(long id);
}
