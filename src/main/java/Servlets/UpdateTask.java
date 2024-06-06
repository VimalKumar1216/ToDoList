package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import DTO.Task;
import DTO.User;

@WebServlet("/edit")
public class UpdateTask extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdesc = req.getParameter("taskdescription");
		String priority = req.getParameter("taskpriority");
		String date = req.getParameter("taskduedate");
		
		User user = (User) req.getSession().getAttribute("user");
		
		Task task = new Task(id, tasktitle, taskdesc, priority, taskdesc, id);
		
		Dao dao = new Dao();
	}
}
