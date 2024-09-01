package com.dao;

import java.sql.*;


public class MyConnection {
	    Connection con=null;
		public Connection getConnection() 
		{
			try {
				System.out.println("Hello");
				Class.forName("oracle.jdbc.OracleDriver");
				System.out.println("Hi");
				//step2: connection to database
			    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
				System.out.println("connect to db: "+con);
	
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
	
}

