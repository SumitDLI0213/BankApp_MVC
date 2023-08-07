package com.digit.JavaTraining.mvcApp.Controller;

import java.io.IOException;

import com.digit.JavaTraining.mvcApp.Model.BankApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet
{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
       {           
          BankApp bankapp=new BankApp();
          bankapp.setBank_id(Integer.parseInt(req.getParameter("bank_id")));
          bankapp.setBank_name(req.getParameter("bank_name"));
          bankapp.setIfsc_code(req.getParameter("ifsc_code"));
          bankapp.setBalance(Integer.parseInt(req.getParameter("balance")));
          bankapp.setEmail(req.getParameter("email"));
          bankapp.setPhone(Long.parseLong(req.getParameter("phone")));
          bankapp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
          bankapp.setPin(Integer.parseInt(req.getParameter("pin")));
          bankapp.setAccno(Integer.parseInt(req.getParameter("accno")));
          bankapp.setCust_name(req.getParameter("cust_name"));
          boolean b= bankapp.Register();
          {
        	  if(b==true)
        	  {
        		  resp.sendRedirect("/BankingApplication/registersuccess.html");
        	  }
        	  else
        	  {
        		  resp.sendRedirect("/BankingApplication/registerfail.html");

        	  }
          }
         
    }
}
