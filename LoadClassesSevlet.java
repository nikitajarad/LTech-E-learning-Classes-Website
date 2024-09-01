package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.LoginDao;
import com.dao.MyConnection;
import com.model.IdentifyCourse;
import com.model.Login;

/**
 * Servlet implementation class LoadClassesSevlet
 */
public class LoadClassesSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClassesSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginController ld=new LoginController();
		String uname=ld.uname;
		Connection con;
		MyConnection mycon=new MyConnection();
		PreparedStatement pstate;
		PrintWriter pw=response.getWriter();
		pw.print("'\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "      <meta charset='utf-8'>\r\n"
				+ "      <title>LTech Classes</title>\r\n"
				+ "      <link rel='stylesheet' href='style.css'>\r\n"
				+ "      <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
				+ "      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'/>\r\n"
				+ "       <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>\r\n"
				+ "	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>\r\n"
				+ "        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>\r\n"
				+ "	</head>\r\n"
				+ " <style>"
				+ " body{background-image: linear-gradient(rgba(0,0,0,0),rgba(0,0,0,0.5)),url('animated.gif');padding:1rem 5%;"
				+ "    	background-size: cover;	color: white; font-weight:20px;}"
				+ " table,tr,td,th{"
				+ "  border: 1px solid black;"
				+ "  border-spacing: 3px;"
				+ "  padding: 3px"
				+ "} "
				+ " </style>"
				+ "   <body>\r\n"
				+ "      <nav>\r\n"
				+ "        <div class='menu-icon'>\r\n"
				+ "            <span class='fas fa-bars'></span>\r\n"
				+ "         </div>\r\n"
				+ "         <div class='logo'>\r\n"
				+ "            LTech Classes\r\n"
				+ "         </div>\r\n"
				+ "         <div class='nav-items'>\r\n"
				+ "            <li><a class='active' href='index.html'>Home</a></li>\r\n"
				+ "             <li><a class='active' href='Courses.html'>Courses</a></li>\r\n"
				+ "            <li><a href='About.html'>About</a></li>\r\n"
				+ "            <li><a href='contact.html'>Contact</a></li>\r\n"
				+ "            <li><a class='active' href='LoginRegister.html'>Login</a></li>\r\n"
				+ "         </div>\r\n"
				+ "         <div class='cancel-icon'>\r\n"
				+ "            <span class='fas fa-times'></span>\r\n"
				+ "         </div>\r\n"
				+ "      </nav><br><br>");
		try {
			con=mycon.getConnection();
			System.out.println(uname);
			pstate=con.prepareStatement("Select * from CheckForCourse where uname=?");
			pstate.setString(1, uname);
			ResultSet rs=pstate.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				if(rs.getString(1).equals("C"))
					pw.print("<center><table><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				if(rs.getString(1).equals("Cpp"))
					pw.print("<html><center><table id='tb1'><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				if(rs.getString(1).equals("Java"))
					pw.print("<html><center><table id='tb1'><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				if(rs.getString(1).equals("Rdbms"))
					pw.print("<html><center><table id='tb1'><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				if(rs.getString(1).equals("Python"))
					pw.print("<html><cenetr><table id='tb1'><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				if(rs.getString(1).equals("JavaScript"))
					pw.print("<html><center><table id='tb1'><tr><td>"+rs.getString(1)+ "</td><td><a href='CCourse.html'><input type='submit' value='Continue'></a></td></tr></table></center><br>");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		pw.print("<html>\r\n"
				+ "<footer class='footer-distributed'>\r\n"
				+ "\r\n"
				+ "			<div class='footer-left'>\r\n"
				+ "          \r\n"
				+ "				<div class='logo1'>\r\n"
				+ "                    LTech Classes\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "				<p class='footer-links'>\r\n"
				+ "					<a href='index.html'>Home</a>\r\n"
				+ "					|\r\n"
				+ "					<a href='About.html'>About Us</a>\r\n"
				+ "					|\r\n"
				+ "					<a href='Courses.html'>Courses</a>\r\n"
				+ "					|\r\n"
				+ "					<a href='contact.html'>Contact</a>\r\n"
				+ "				</p>\r\n"
				+ "\r\n"
				+ "				<p class='footer-company-name'>© 2021 LTech Learning Solutions Pvt. Ltd.</p>\r\n"
				+ "			</div>\r\n"
				+ "\r\n"
				+ "			<div class='footer-center'>\r\n"
				+ "				<div>\r\n"
				+ "					<i class='fa fa-map-marker'></i>\r\n"
				+ "					  <p><span>309 - Rupa Solitaire,\r\n"
				+ "						 Bldg. No. A - 1, Sector - 1</span>\r\n"
				+ "						Mahape, Navi Mumbai - 400710</p>\r\n"
				+ "				</div>\r\n"
				+ "\r\n"
				+ "				<div>\r\n"
				+ "					<i class='fa fa-phone'></i>\r\n"
				+ "					<p>+91 22-27782183</p>\r\n"
				+ "				</div>\r\n"
				+ "				<div>\r\n"
				+ "					<i class='fa fa-envelope'></i>\r\n"
				+ "					<p><a href='index.html'>support@ltechclasses.com</a></p>\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "			<div class='footer-right'>\r\n"
				+ "				<p class='footer-company-about'>\r\n"
				+ "					<span>About the classes</span>\r\n"
				+ "					We offer training and skill building courses across Technology, Design, Management, Science and Humanities.</p>\r\n"
				+ "				<div class='footer-icons'>\r\n"
				+ "					<a href='https://www.facebook.com/'><i class='fa fa-facebook'></i></a>\r\n"
				+ "					<a href='https://twitter.com/'><i class='fa fa-twitter'></i></a>\r\n"
				+ "					<a href='https://www.instagram.com/'><i class='fa fa-instagram'></i></a>\r\n"
				+ "					<a href='https://www.linkedin.com/signup'><i class='fa fa-linkedin'></i></a>\r\n"
				+ "					<a href='https://www.youtube.com/'><i class='fa fa-youtube'></i></a>\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "		</footer>\r\n"
				+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
