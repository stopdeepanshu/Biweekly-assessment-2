package org.insurancecomp;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.insurancecomp.config.SpringConfig;
import org.insurancecomp.dao.CustomerDao;
import org.insurancecomp.entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/register")
public class CustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");

		if (name == null || name.trim().equals("")) {
			res.sendRedirect("register.jsp?msg=Please enter the name, it can't be empty");
			return;
		}

		if (!Pattern.matches("[a-zA-Z ]+", name)) {
			res.sendRedirect("register.jsp?msg=Name must contain alphabets!");
			return;
		}

		if (email == null || email.trim().equals("")) {
			res.sendRedirect("register.jsp?msg=Email you cannot leave empty.");
			return;
		}

		if (!email.contains("@")) {
			res.sendRedirect("register.jsp?msg=Email must have '@' inside that.");
			return;
		}

		if (phone == null || phone.trim().equals("")) {
			res.sendRedirect("register.jsp?msg=Phone number is must.");
			return;
		}

		if (!Pattern.matches("\\d{10}", phone)) {
			res.sendRedirect("register.jsp?msg=Phone number should have 10 digits.");
			return;
		}

		if (password == null || password.trim().equals("")) {
			res.sendRedirect("register.jsp?msg=You cant leave the password empty.");
			return;
		}

		if (password.length() < 8) {
			res.sendRedirect("register.jsp?msg=Password must contains 8 characters minimum.");
			return;
		}

		String passPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&]).{8,}$";

		if (!Pattern.matches(passPattern, password)) {
			res.sendRedirect("register.jsp?msg=Password must contain letter digit specialchar");
			return;
		}

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		CustomerDao dao = context.getBean(CustomerDao.class);

		Customer c = new Customer();

		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
		c.setPassword(password);

		dao.saveCustomer(c);

		res.sendRedirect("login.jsp?msg=Registered Successfully");

	}
}