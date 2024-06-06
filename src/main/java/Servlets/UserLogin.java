package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao;
import DTO.User;

@WebServlet("/login")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Dao dao = new Dao();
		try {
			User user = dao.findByEmail(email);
			if (user != null) {
				
				if (user.getUserPassword().equals(password)) {
					
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					
					req.getRequestDispatcher("Home.jsp").forward(req, resp);
				}
			 else {
				req.setAttribute("message", "incorrect password");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}	
		} else {
			req.setAttribute("message", "incorrect email");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		
		} catch (ClassNotFoundException e) {
			
		}
		catch(SQLException e){
			e.printStackTrace();
			}
		}
		
	}
