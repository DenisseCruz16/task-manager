package com.dmcg.task_manager.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TASK")
public class Task {

	//@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@NotNull
	private String title;
	private String description;
	@Column(name = "DUE_DATE")
	private Date dueDate;
	
	private enum Status {PENDING,IN_PROGRESS,COMPLETED}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Task() {
		
	}
	
	public Task(String id, String title, String description, Date dueDate, Status status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	};
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status=status;
	}
	
	
	
	
	
}
