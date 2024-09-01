package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Enroll;
import com.model.IdentifyCourse;
import com.model.SendOTP;

/**
 * Servlet implementation class SendServlet
 */
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static long phe;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phone1=request.getParameter("phone");
		String course=request.getParameter("course");
		PrintWriter pw=response.getWriter();
		if(course == null || course.length()==0 || course.equals("")) {
			   // " " => empty string
			pw.print("<body background-image='animated.gif'><script language='javascript'>"+
					"alert( 'Course name is required' );"+
					"location='Enroll.html';"+
					"</script><p></p>");
			   
			}
		else if(phone1==null || phone1=="0" || phone1.equals(" ")) {
			pw.print("<body bgcolor='#088F8F'><script language='javascript'>"+
					"alert( 'Phone number is required' );"+
					"location='Enroll.html';"+
					"</script><p></p>");
		}
		else {
		long phone=Long.parseLong(phone1);
		
		
		

		IdentifyCourse id=new IdentifyCourse();
		System.out.println(course);
		id.setCourse(course);
		System.out.println(course);
		phe=phone;
		SendOTP send=new SendOTP(Long.toString(phone));
		send.sentOtp();
		response.sendRedirect("OTPVerify.html");
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
