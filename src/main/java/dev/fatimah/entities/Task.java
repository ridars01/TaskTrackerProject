package dev.fatimah.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	private String task ; 
	private String description ; 
	private int priority ;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int taskId ; 
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Task(String task, String description, int priority , int taskId) {
		super();
		this.task = task;
		this.description = description;
		this.priority = priority;
		this.taskId = taskId ; 
	}


	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	@Override
	public String toString() {
		return "Task [task=" + task + ", description=" + description + ", priority=" + priority + ", taskId=" + taskId
				+ "]";
	} 	

}
