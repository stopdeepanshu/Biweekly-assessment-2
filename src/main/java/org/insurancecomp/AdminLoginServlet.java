package org.insurancecomp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = req.getParameter("username");

		String pass = req.getParameter("password");

		if (uname.equals("admin") && pass.equals("admin123")) {

			HttpSession session = req.getSession();

			session.setAttribute("admin", "true");

			resp.sendRedirect("adminHome.jsp");
		}

		else {
			resp.sendRedirect("adminLogin.jsp");
		}
	}
}