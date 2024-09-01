package com.controller;

import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.controller.*;
import com.dao.*;
import com.model.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginController() {
		super();
	}
	static String uname;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		RequestDispatcher dispatcher;
		Login ln=new Login(uname,pass);
		LoginDao dao=new LoginDao();
		boolean b=dao.createLogin(ln);
		PrintWriter pw=response.getWriter();
		if(b)
		{
			response.sendRedirect("Enrolled.html");
		}else {
			dispatcher=request.getRequestDispatcher("Regitration.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
