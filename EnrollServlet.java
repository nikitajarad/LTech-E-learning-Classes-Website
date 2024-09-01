package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Enrolldao;
import com.dao.RegisterDao;
import com.model.Enroll;
import com.model.IdentifyCourse;
import com.model.Register;
import com.model.SendOTP;

/**
 * Servlet implementation class EnrollServlet
 */
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String otpTxt=request.getParameter("otptxt");
		SendServlet sets=new SendServlet();
		IdentifyCourse id=new IdentifyCourse();
		String course=id.getCourse();
		long phone=sets.phe;
		Enroll en=new Enroll(phone, otpTxt);
		Enrolldao dao=new Enrolldao();
		int i=dao.searchData(phone, otpTxt,course);
		PrintWriter pw=response.getWriter();

		if(i==1)
		{
			response.sendRedirect("LoginRegister.html");
		}
		else if(i==-2) {
			pw.print("<body bgcolor='#088F8F'><script language='javascript'>"+
					"alert( 'You have already enrolled for this class' );"+
					"location='Enroll.html';"+
					"</script><p></p>");
		}
		else
		{
			pw.print("<body bgcolor='#088F8F'><script language='javascript'>"+
					"alert( 'Please enter valid OTP' );"+
					"location='OTPVerify.html';"+
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
