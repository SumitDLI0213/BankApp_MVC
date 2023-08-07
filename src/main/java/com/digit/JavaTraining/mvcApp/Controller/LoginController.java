package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		HttpSession session = req.getSession(true);
		bankapp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
		bankapp.setPin(Integer.parseInt(req.getParameter("pin")));

		boolean b = bankapp.login();
 
		if (b == true) {
			session.setAttribute("BankApp", bankapp);
			session.setAttribute("accno", bankapp.getAccno());
			session.setAttribute("cust_name", bankapp.getCust_name());
			session.setAttribute("cust_id", bankapp.getCust_id());

			resp.sendRedirect("/mvc_BankApp/homepage.jsp");
		} else {
			resp.sendRedirect("/mvc_BankApp/loginfail.html");

		}
	}
}
