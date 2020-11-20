package dev.fatimah.services;

import java.util.Set;

import dev.fatimah.daos.TaskDAO;
import dev.fatimah.daos.TaskDAOImpl;
import dev.fatimah.entities.Task;

public class TaskServiceImpl implements TaskService{

	private static TaskDAO tdao = new TaskDAOImpl(); 
	
	@Override
	public Task addTask(Task task) {
		if(task.getPriority()<1) {
			task.setPriority(1);
		}
		if(task.getPriority()>10) {
			task.setPriority(10);
		}
		tdao.createTask(task) ; 
		return task;
	}

	@Override
	public Set<Task> retrieveAllTasks() {
		Set<Task> tasks = tdao.getAllTasks() ; 
		return tasks;
	}

}
