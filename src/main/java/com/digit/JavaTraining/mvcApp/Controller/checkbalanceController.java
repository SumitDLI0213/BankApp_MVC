package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkbalance")
public class checkbalanceController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		HttpSession session = req.getSession();
		bankapp.setAccno((int) session.getAttribute("accno"));

		boolean b = bankapp.checkbalance();
		{
			if (b == true) {
				session.setAttribute("balance", bankapp.getBalance());
				session.setAttribute("cust_name", bankapp.getCust_name());
				resp.sendRedirect("/mvc_BankApp/balance.jsp");
			} else {
				resp.sendRedirect("/mvc_BankApp/loginfail.html");

			}
		}
	}
}
