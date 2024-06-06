package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Dao;
import DTO.User;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class UserSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		long contact = Long.parseLong(req.getParameter("usercontact"));
		String password = req.getParameter("userpassword");

		Part image = req.getPart("userimage");
		byte[] imagebytes = image.getInputStream().readAllBytes();

		User user = new User();
		user.setUserId(id);
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserContact(contact);
		user.setUserPassword(password);
		user.setUserImage(imagebytes);

		Dao dao = new Dao();

		try {
			dao.SaveUser(user);
			resp.sendRedirect("Login.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
