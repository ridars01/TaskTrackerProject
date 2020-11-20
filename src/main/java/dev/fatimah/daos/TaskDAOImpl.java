package dev.fatimah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dev.fatimah.entities.Task;
import dev.fatimah.utils.ConnectionUtilTwo;

public class TaskDAOImpl implements TaskDAO{

	public Task createTask(Task task) {
		try(Connection conn = ConnectionUtilTwo.getConnection()){
			String sql = "INSERT INTO TASKS (TASK , TASK_DESCRIPTION , PRIORITY) VALUES (?,? , ?)" ; 
			String [] keys = {"TASK_ID"} ; 
			PreparedStatement ps = conn.prepareStatement(sql , keys) ; 
			ps.setString(1, task.getTask());
			ps.setString(2, task.getDescription());
			ps.setInt(3, task.getPriority());
			ps.executeLargeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys(); 
			rs.next();
			
			int id = rs.getInt(1); 
			task.setTaskId(id);
			return task ; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public Set<Task> getAllTasks() {
		try(Connection conn = ConnectionUtilTwo.getConnection()){
			String sql = "SELECT * FROM TASKS" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Set<Task> tasks = new HashSet<Task>() ; 
			
			while(rs.next()) {
				Task task = new Task(); 
				task.setTaskId(rs.getInt("TASK_ID"));
				task.setTask(rs.getString("TASK"));
				task.setDescription(rs.getNString("TASK_DESCRIPTION"));
				task.setPriority(rs.getInt("PRIORITY"));
				tasks.add(task);
			}
			return tasks; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public Task deleteTaskById(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


