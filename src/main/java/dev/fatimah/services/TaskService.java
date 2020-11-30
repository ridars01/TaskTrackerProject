package dev.fatimah.services;

import java.util.Set;

import dev.fatimah.entities.Task;

public interface TaskService {
	
	Task addTask(Task task); 
	
	Set<Task> retrieveAllTasks(); 
	
	Set<Task>filterById(int filter) ; 
	
//	Task updateTask(Task task); 
	
	Task deleteTask(int taskId) ; 
	
	Task updateTask(Task task) ; 
	
	
	Task getTaskById(int taskId) ; 

}
