package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import DTO.Task;
import DTO.User;

public class Dao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/office?user=root&password=root");

		return connection;
	}

	public int SaveUser(User user) throws SQLException, ClassNotFoundException {

		Connection connection = getConnection();

		PreparedStatement pst = connection.prepareStatement("insert into user values(?,?,?,?,?,?)");

		pst.setInt(1, user.getUserId());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getUserEmail());
		pst.setLong(4, user.getUserContact());
		pst.setString(5, user.getUserPassword());
		Blob image = new SerialBlob(user.getUserImage());
		pst.setBlob(6, image);

		return pst.executeUpdate();

	}

	public User findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		PreparedStatement pst = connection.prepareStatement("select * from user where useremail=?");
		pst.setString(1, email);

		ResultSet res = pst.executeQuery();
		User u = new User();

		if (res.next()) {
			u.setUserId(res.getInt(1));
			u.setUserName(res.getString(2));
			u.setUserEmail(res.getString(3));
			u.setUserContact(res.getLong(4));
			u.setUserPassword(res.getString(5));
			Blob bl = res.getBlob(6);
			byte[] image = bl.getBytes(1, (int) bl.length());
			u.setUserImage(image);
			return u;
		}
		return null;
	}

	public int saveTask(Task t) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();

		PreparedStatement pst = con.prepareStatement("insert into task values(?,?,?,?,?,?)");

		pst.setInt(1, t.getTaskId());
		pst.setString(2, t.getTaskTitle());
		pst.setString(3, t.getTaskDescription());
		pst.setString(4, t.getTaskPriority());
		pst.setString(5, t.getTaskDueDate());
		pst.setInt(6, t.getUserId());
		

		return pst.executeUpdate();
	}
	
	public int deleteTask(int taskId) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from task where id=?");
		pst.setInt(1, taskId);
		int value = pst.executeUpdate();
		return value;
	}
	
	public List<Task> getAllTaskById(int taskId) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		PreparedStatement pst =  con.prepareStatement("select * from task where taskId=?");
		
		pst.setInt(1, taskId);
		
		ResultSet res = pst.executeQuery();
		List<Task> l1= new ArrayList<Task>();
		
		while (res.next()) {
			Task task=new Task(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
			l1.add(task);
		}
		return l1;
	}
	
	public int updateTask(Task task) throws SQLException, ClassNotFoundException {
	Connection con = getConnection();
	PreparedStatement pst = con.prepareStatement("update task taskTitle=?, taskPriority=?,taskDueDate=?,userId=? where task=?");
	
	pst.setInt(1, task.getTaskId());
	pst.setString(2, task.getTaskTitle());
	pst.setString(3, task.getTaskDescription());
	pst.setString(4, task.getTaskPriority());
	pst.setString(5, task.getTaskDueDate());
	pst.setInt(6, task.getUserId());
	
	
	return pst.executeUpdate();
	}
	
}
