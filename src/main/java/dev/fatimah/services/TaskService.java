package dev.fatimah.services;

import java.util.Set;

import dev.fatimah.entities.Task;

public interface TaskService {
	
	Task addTask(Task task); 
	
	Set<Task> retrieveAllTasks(); 
	
//	Task updateTask(Task task); 
	
	Task deleteTask(int taskId) ; 
	
	Task updateTask(Task task) ; 
	
	
	Task getTaskById(int taskId) ; 

}
