package com.dmcg.task_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmcg.task_manager.model.Task;
import com.dmcg.task_manager.service.TaskServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@GetMapping
	public List<Task> getTasks() {
		return taskService.getTasks();
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable String id) {
		return taskService.getTaskById(id);
	}
	
	@PostMapping
	public Task createTask(@RequestBody @Valid Task task) {
		return taskService.createTask(task);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable String id,@RequestBody @Valid Task task) {
		return taskService.updateTask(id, task);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
	

}
