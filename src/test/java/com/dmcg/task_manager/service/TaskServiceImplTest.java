package com.dmcg.task_manager.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.dmcg.task_manager.model.Task;
import com.dmcg.task_manager.model.Task.Status;
import com.dmcg.task_manager.repository.ITaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {
	
	@Mock
	private ITaskRepository taskRepository;
	
	@InjectMocks
	private TaskServiceImpl taskService;
	
	@Test
	public void createTaskSuccessfulSaveAllValues() {
		Task task = new Task("e3b50357-d8f1-49fc-9d10-213e31fb2247", "Test service", "Test description",LocalDate.parse("2030-10-29"),Status.PENDING);
		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(task);
		Task savedTask = taskService.createTask(task);
		Assertions.assertEquals("e3b50357-d8f1-49fc-9d10-213e31fb2247", savedTask.getId());
		Assertions.assertEquals(task, savedTask);
	}
	
	@Test
	public void createTaskSuccessfulSaveRequiredlValuesOnly() {
		Task task = new Task("e3b50357-d8f1-49fc-9d10-213e31fb2247", "Test service without desc and duedate",null, null,Status.PENDING);
		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(task);
		Task savedTask = taskService.createTask(task);
		Assertions.assertEquals("e3b50357-d8f1-49fc-9d10-213e31fb2247", savedTask.getId());
		Assertions.assertEquals("Test service without desc and duedate", savedTask.getTitle());
		Assertions.assertEquals(Status.PENDING, savedTask.getStatus());		
		Assertions.assertEquals(task, savedTask);
	}
	
	@Test
	public void createTaskFailureMissingRequiredValuesOne() {
		Task task = new Task("e3b50357-d8f1-49fc-9d10-213e31fb2247", null,null, null,Status.PENDING);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(task);
        });
	}
	
	@Test
	public void createTaskFailureMissingRequiredValuesTwo() {
		Task task = new Task(null, null,null, null,Status.PENDING);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(task);
        });
	}
	
	

}
