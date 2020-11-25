package dev.fatimah.daotests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import dev.fatimah.daos.HibernateTaskDAOImpl;
import dev.fatimah.daos.TaskDAO;
import dev.fatimah.daos.TaskDAOImpl;
import dev.fatimah.entities.Task;

public class TaskDAOTests {

	private static TaskDAO tdao = new HibernateTaskDAOImpl();
	
	@Test
	public void createTaskTest() {
		Task task = new Task("Social Studies Assignment" , "research paper" , 7 ,0) ; 
		tdao.createTask(task) ; 
		System.out.println(task);
		Assert.assertNotEquals(task.getTaskId() , 0);
	}
	
	@Test
	public void createTaskTest2() {
		Task task = new Task("Math Assignmnet" , "pages 3-4 ODD" , 5 ,0) ; 
		tdao.createTask(task) ; 
		System.out.println(task);
		Assert.assertNotEquals(task.getTaskId() , 0);
	}

	@Test
	public void getAllTasks() {
		Set<Task> tasks = tdao.getAllTasks() ;
		System.out.println (tasks);
	}
	
	@Test
	public void deleteTaskTest() {
	Task  deleteTask = tdao.deleteTaskById(2);
	System.out.println("The Task has been deleted");
	}

}
