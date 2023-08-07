package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.digit.JavaTraining.mvcApp.Model.BankApp;
import com.digit.JavaTraining.mvcApp.Model.transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transcationDetails")
public class transactioncontroller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		BankApp bankApp = new BankApp();
		transaction trns = new transaction();

		int accno = (int) session.getAttribute("accno");
		System.out.println(accno);
		trns.setS_accno(accno);

		ArrayList<transaction> list = trns.alltransaction(accno);

		System.out.println(list.size());

		session.setAttribute("ALL_TRANSACTIONS", list);
		session.setAttribute("isListGenerated", "true");

		resp.sendRedirect("/mvc_BankApp/Transcationdetails.jsp");
	}
}