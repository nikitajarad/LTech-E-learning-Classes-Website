package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDao {
	Connection con=null;
	MyConnection mcon=new MyConnection();
	PreparedStatement pstate;
	int i=0;
	int flag=1;
	static String courses[] = null;
	public String[] searchData(String unme) {
		con=mcon.getConnection();
		String uname;
		String unames = null;
		String otp = null;
		
		int i=0;

		try {
			pstate=con.prepareStatement("select * from RegisterInLTech where uname=?");
			pstate.setString(1, unme);
			ResultSet rs=pstate.executeQuery();
			
				while(rs.next())
				{
					do
					{
						System.out.println("Hello: "+courses[i]);
					courses[i]=rs.getString(1);
					System.out.println("Courses:"+courses[i]);
					i++;
				}while(i<20);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return courses;
		}
}
