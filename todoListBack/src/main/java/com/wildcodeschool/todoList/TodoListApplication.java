package com.wildcodeschool.todoList;

import com.wildcodeschool.todoList.entity.Task;
import com.wildcodeschool.todoList.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedData(TaskRepository repo) {
		return args -> {
			repo.save(new Task("Task no. 1"));
			repo.save(new Task("Task no. 2"));
			repo.save(new Task("Task no. 3"));
};
	}
}
