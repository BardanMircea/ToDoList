package com.wildcodeschool.todoList.service;

import com.wildcodeschool.todoList.entity.Task;
import com.wildcodeschool.todoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(@Autowired TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public void deleteById(long id) {
        this.taskRepository.deleteById(id);
    }
}
