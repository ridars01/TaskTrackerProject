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

	@Override
	public Set<Task> getAllTasks() {
		try(Session session = HibernateUtil.getSession();){
			Query<Task> taskQuery = session.createQuery("from task");
			List<Task> taskList = taskQuery.list(); 
			return new HashSet<>(taskList) ;
		}
	}

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

	
	
	
}


