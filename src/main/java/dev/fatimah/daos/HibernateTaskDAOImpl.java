package dev.fatimah.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.fatimah.entities.Task;
import dev.fatimah.utils.HibernateUtil;

public class HibernateTaskDAOImpl implements TaskDAO {
//CREATE TASK
	@Override
	public Task createTask(Task task) {
		try(Session session = HibernateUtil.getSession(); ){
			Transaction tx = session.beginTransaction();
			
			int id = (int) session.save(task);
			task.setTaskId(id);
			
			tx.commit();
			return task ;
			
		}
	}
//GET ALL TASKS 
	@Override
	public Set<Task> getAllTasks() {
		try(Session session = HibernateUtil.getSession();){
			Query<Task> taskQuery = session.createQuery("from Task");
			List<Task> taskList = taskQuery.list(); 
			System.out.println("Query List size: "+ taskList.size());
			return new HashSet<>(taskList) ;
		}
	}

	//DELETE TASK BY ID 
	@Override
	public Task deleteTaskById(int taskId) {
		try(Session session = HibernateUtil.getSession();){
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			Task task = session.get(Task.class, taskId) ; 
			if(task != null) {
				session.delete(task);
			}
			transaction.commit(); 
			return task; 
		}
		
	}
//GET TASK BY ID 
	@Override
	public Task getTaskbyId(int taskId) {
	try(Session session = HibernateUtil.getSession()){
		Task t = session.get(Task.class, taskId) ; 
		
		return t ; 
	}
	}
	//UPDATE
	@Override 
	public Task updateTask(Task task) {
		try(Session session = HibernateUtil.getSession()){
			Transaction tx = session.beginTransaction() ; 
			Task updatedTask = (Task) session.merge(task);
			tx.commit();
			return updatedTask;
		}
	}

	
	
	
}


