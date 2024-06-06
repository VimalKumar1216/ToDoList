package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import DTO.Task;
import DTO.User;

@WebServlet("/addtask")
public class AddTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int taskId = Integer.parseInt(req.getParameter("taskid"));
	String taskTitle = req.getParameter("tasktitle");
	String taskDescription=req.getParameter("taskdescription");
	String taskPriority = req.getParameter("taskpriority");
    String taskDueDate = req.getParameter("taskduedate");
    
    User user = (User)req.getSession().getAttribute("user");
    
    Task task =  new Task(taskId, taskTitle, taskDescription, taskPriority, taskDueDate, user.getUserId());
    
    Dao dao = new Dao();
    try {
		dao.saveTask(task);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
}
