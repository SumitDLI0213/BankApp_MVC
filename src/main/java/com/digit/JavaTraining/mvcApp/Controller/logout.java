package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class logout extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		HttpSession session = req.getSession();
		boolean b = bankapp.logout();

		if (b == true) 
		{
			session=req.getSession();
	    	session.invalidate();
			resp.sendRedirect("/mvc_BankApp/welcome.html");
			
		} else {
			resp.sendRedirect("/mvc_BankApp/welcome.html");

		}
	}
}
