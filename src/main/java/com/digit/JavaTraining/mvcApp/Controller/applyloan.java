package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/loan")
public class applyloan extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		HttpSession session = req.getSession();

		 int lid = Integer.parseInt(req.getParameter("lid"));

//		 bankapp.setAccno((int) session.getAttribute("accno"));
//		 bankapp.setlid((int) session.getAttribute("lid"));
//		 bankapp.setl_type((String) session.getAttribute("l_type"));
//		 bankapp.settenure((int) session.getAttribute("tenure"));
//		 bankapp.setintrest((Float)session.getAttribute("intrest"));
//		 bankapp.setdescription((String) session.getAttribute("description"));

		

		boolean b = bankapp.applyloan(lid);

		if (b == true) {
			
			session.setAttribute("lid", bankapp.getlid());
            session.setAttribute("l_type", bankapp.getl_type());
            session.setAttribute("tenure", bankapp.gettenure());
            session.setAttribute("interest", bankapp.getinterest());
            session.setAttribute("description", bankapp.getdescription());
			resp.sendRedirect("/mvc_BankApp/loandetails.jsp");
		} else {
			resp.sendRedirect("/mvc_BankApp/loandetailsfail.html");

		}
	}
}
