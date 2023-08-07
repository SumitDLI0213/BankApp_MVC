package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/changepassword")
public class changepinController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		HttpSession session = req.getSession();

		int opin = Integer.parseInt(req.getParameter("opin"));
		int npin = Integer.parseInt(req.getParameter("npin"));
		int cpin = Integer.parseInt(req.getParameter("cpin"));

		 bankapp.setAccno((int) session.getAttribute("accno"));

		

		boolean b = bankapp.changepin(opin, npin, cpin);

		if (b == true) {
			

			resp.sendRedirect("/mvc_BankApp/passwordchangesucess.html");
		} else {
			resp.sendRedirect("/mvc_BankApp/passwordchangefail.html");

		}

	}
}
