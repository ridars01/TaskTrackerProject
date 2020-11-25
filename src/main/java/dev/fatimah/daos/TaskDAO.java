package dev.fatimah.daos;

import java.util.Set;

import dev.fatimah.entities.Task;

public interface TaskDAO {
	Task createTask(Task task);

	Set<Task>getAllTasks();
	
	Task deleteTaskById(int taskId); 
	
	//Task getTaskbyId(int id);

	//Task getTaskbyId(Task id);

	Task getTaskbyId(int taskId);

//	boolean updateTask(int id);

	Task updateTask(Task task); 

}
