package com.dmcg.task_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmcg.task_manager.exception.IdNotMatchingException;
import com.dmcg.task_manager.model.Task;
import com.dmcg.task_manager.repository.ITaskRepository;

@Service
public class TaskServiceImpl implements ITaskService{
	
	@Autowired
	private ITaskRepository taskRepository;
	

	@Override
	public Task createTask(Task task) {
		
		validateTask(task);
		taskRepository.findById(task.getId()).ifPresent((existingTask)->
		{throw new IllegalArgumentException("ID: "+task.getId()+" is already present");}
		);
			
		return taskRepository.save(task);
		
	}

	@Override
	public List<Task> getTasks() {
		return (List<Task>)taskRepository.findAll();
	}

	@Override
	public Task getTaskById(String id) {
		Task task = taskRepository.findById(id).get();
		return task;
	}

	@Override
	public Task updateTask(String id, Task taskToUpdate) {
		
		validateTask(taskToUpdate);
		Task task = taskRepository.findById(id).get();
		
		if(!taskToUpdate.getId().equals(id)){
			throw new IdNotMatchingException("Ids provided are not matching.");
		}
		
		//task.setId(taskToUpdate.getId());
		task.setTitle(taskToUpdate.getTitle());
		task.setDescription(taskToUpdate.getDescription());
		task.setDueDate(taskToUpdate.getDueDate());
		task.setStatus(taskToUpdate.getStatus());
			
		return taskRepository.save(task);
		
	}

	@Override
	public void deleteTask(String id) {
		
		taskRepository.findById(id).get();
		taskRepository.deleteById(id);
		
	}
	
	
	public void validateTask(Task task) {
		if(task.getId() == null || task.getTitle()==null || task.getStatus()==null) 
			 throw new IllegalArgumentException("ID , title and status are mandatory");
	}
	
}
