package dev.fatimah.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import dev.fatimah.daos.HibernateTaskDAOImpl;
import dev.fatimah.daos.TaskDAO;
import dev.fatimah.daos.TaskDAOImpl;
import dev.fatimah.entities.Task;

public class TaskServiceImpl implements TaskService{

	private static TaskDAO tdao = new 	HibernateTaskDAOImpl(); 
	
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


	@Override
	public Task deleteTask(int taskId) {
		Task deleteTask = tdao.deleteTaskById(taskId) ; 
		return deleteTask;
	}

	@Override
	public Task updateTask(Task task) {
		tdao.updateTask(task) ; 
		return task ; 
	}

	@Override
	public Task getTaskById(int taskId) {
		Task t = tdao.getTaskbyId(taskId) ; 
		return t ; 
	}

	@Override
	public Set<Task> filterById(int filter) {
		Set<Task> orderTasks = new HashSet<Task>(); 
		Set<Task> allTasks = this.retrieveAllTasks() ; 
		
		for(Task t : allTasks) {
			if(t.getTaskId() > filter) {
				orderTasks.add(t);
				}
			}
		
		return orderTasks; 
		}

	

}
