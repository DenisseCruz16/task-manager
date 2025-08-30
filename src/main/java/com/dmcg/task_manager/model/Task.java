package com.dmcg.task_manager.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	private String id;
	private String title;
	private String description;
	private Date date;
	
	private enum Status {Pending,In_progress,Completed}
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Task(String id, String title, String description, Date date, Status status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	};
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status=status;
	}
	
	
	
	
	
}
