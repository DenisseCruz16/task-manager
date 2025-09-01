package com.dmcg.task_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmcg.task_manager.model.Task;
import com.dmcg.task_manager.service.TaskServiceImpl;

@RestController
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskService.getTasks();
	}

}
