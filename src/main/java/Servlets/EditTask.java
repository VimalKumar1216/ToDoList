package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import DTO.Task;

public class EditTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Dao dao = new Dao();
		 
//		Task task = dao.findById(id);
//		req.setAttribute("task", task);
		
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
		

	}
}
