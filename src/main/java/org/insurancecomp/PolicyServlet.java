package org.insurancecomp;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.insurancecomp.config.SpringConfig;
import org.insurancecomp.dao.PolicyDao;
import org.insurancecomp.entity.Policy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/policy")
public class PolicyServlet extends HttpServlet {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	PolicyDao dao = context.getBean(PolicyDao.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");

		String premium = req.getParameter("premium");

		String duration = req.getParameter("duration");

		if (name == null || name.trim().equals("")) {
			res.sendRedirect("addPolicy.jsp?msg=Policy Name Required");
			return;
		}

		if (!Pattern.matches("[a-zA-Z ]+", name)) {
			res.sendRedirect("addPolicy.jsp?msg=Policy Name Alphabets Only");
			return;
		}

		if (premium == null || premium.trim().equals("")) {
			res.sendRedirect("addPolicy.jsp?msg=Premium is mandatory, please retry.");
			return;
		}

		if (!Pattern.matches("\\d+(\\.\\d+)?", premium)) {
			res.sendRedirect("addPolicy.jsp?msg=premium must be in number only");
			return;
		}

		double prem = Double.parseDouble(premium);

		if (prem <= 0) {
			res.sendRedirect("addPolicy.jsp?msg=premium cannot be in negative.");
			return;
		}

		if (duration == null || duration.trim().equals("")) {
			res.sendRedirect("addPolicy.jsp?msg=duration is mandatory.");
			return;
		}

		if (!Pattern.matches("\\d+", duration)) {
			res.sendRedirect("addPolicy.jsp?msg=Duration Digits Only");
			return;
		}

		int dur = Integer.parseInt(duration);

		if (dur <= 0) {
			res.sendRedirect("addPolicy.jsp?msg=duration cannot be in negative.");
			return;
		}

		Policy p = new Policy();

		p.setPolicyName(name);

		p.setPremium(prem);

		p.setDuration(dur);

		dao.addPolicy(p);

		res.sendRedirect("adminHome.jsp?msg=Policy Added");

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Policy> list = dao.getPolicies();

		req.setAttribute("policies", list);

		RequestDispatcher rd = req.getRequestDispatcher("viewPolicies.jsp");

		rd.forward(req, res);

	}

}