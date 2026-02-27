package org.insurancecomp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.insurancecomp.config.SpringConfig;
import org.insurancecomp.dao.CustomerDao;
import org.insurancecomp.entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	CustomerDao dao = context.getBean(CustomerDao.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		String password = req.getParameter("password");

		Customer c = dao.login(email, password);

		if (c != null) {
			HttpSession session = req.getSession();

			session.setAttribute("cid", c.getId());

			resp.sendRedirect("customerHome.jsp");
		}

		else {
			resp.sendRedirect("login.jsp");
		}

	}
}