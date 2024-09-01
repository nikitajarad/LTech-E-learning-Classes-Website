package com.dao;

import com.model.*;
import java.sql.*;

public class LoginDao {
	Connection con=null;
	MyConnection mycon=new MyConnection();
	PreparedStatement pstate;
	boolean status;
	static String uname;
	public boolean createLogin(Login ln)
	{
		con=mycon.getConnection();	
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from RegisterInLTech where uname=? and pass=?");
		                preparedStatement.setString(1, ln.getUname());
		                preparedStatement.setString(2, ln.getPass());

		                System.out.println(preparedStatement);
		                ResultSet rs = preparedStatement.executeQuery();
		                status=rs.next();
		                while(rs.next()) {
		                	uname=rs.getString(2); 
		                	System.out.println(uname);
		                }
			if(status)
			{
				System.out.println("Login successfull");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String getUname() {
		return uname;
		
	}
}
