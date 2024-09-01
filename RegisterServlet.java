package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		long phone=Long.parseLong(request.getParameter("phone"));
		String pass=request.getParameter("pass");
		Register rw=new Register(uname,email,phone,pass);
		RegisterDao dao=new RegisterDao();
		int i=dao.createRegister(rw);
		PrintWriter pw=response.getWriter();
		if(i>0)
		{
			pw.print("<body bgcolor='#088F8F'><script language='javascript'>"+
					"alert( 'Registration Successful' );"+
					"location='LoginRegister.html';"+
					"</script><p></p>");
			
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
