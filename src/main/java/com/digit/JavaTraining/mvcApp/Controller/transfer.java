package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class transfer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		BankApp bankApp = new BankApp();
		bankApp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
		bankApp.setBank_name(req.getParameter("bank_name"));
		bankApp.sets_ifsc(req.getParameter("ifsc_code"));
		bankApp.sets_accno(Integer.parseInt(req.getParameter("sender_accno")));
		bankApp.setr_ifsc(req.getParameter("reciever_ifsc"));
		bankApp.setr_accno(Integer.parseInt(req.getParameter("reciever_accno")));
		bankApp.setamount(Integer.parseInt(req.getParameter("amount")));
		bankApp.setPin(Integer.parseInt(req.getParameter("pin")));
		
		System.out.println(bankApp.getCust_id());
		System.out.println(bankApp.getPin());
		
		boolean b = bankApp.transfer();
		if (b == true) {
			resp.sendRedirect("/mvc_BankApp/transfersucces.html");
		} else {
			resp.sendRedirect("/mvc_BankApp/transferfail.jsp");
		}

	}
}
