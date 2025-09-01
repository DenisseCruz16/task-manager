package com.dmcg.task_manager.service;

import java.util.List;

import com.dmcg.task_manager.model.Task;

public interface ITaskService {

	//Create task
	public Task createTask(Task task);	
		
	//Get list of tasks
	public List<Task> getTasks();
	
	//Get task details by id
	public Task getTaskById(String id);
	
	//Update task
	public Task updateTask(String id, Task taskToUpdate);
	
	//Delete task
	public void deleteTask(String id);
	
	
}
