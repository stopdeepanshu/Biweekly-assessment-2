package org.insurancecomp;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.insurancecomp.config.SpringConfig;
import org.insurancecomp.dao.PurchaseDao;
import org.insurancecomp.entity.Purchase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	PurchaseDao dao = context.getBean(PurchaseDao.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int cid = (int) session.getAttribute("cid");

		int pid = Integer.parseInt(req.getParameter("pid"));

		Purchase p = new Purchase();

		p.setCustomerId(cid);

		p.setPolicyId(pid);

		p.setPurchaseDate(new Date().toString());

		dao.buyPolicy(p);

		res.sendRedirect("customerHome.jsp");
	}
}