package dev.fatimah.daos;

import java.util.Set;

import dev.fatimah.entities.Task;

public interface TaskDAO {
	Task createTask(Task task);

	Set<Task>getAllTasks();
	
	Task deleteTaskById(int taskId); 
	
	

}
