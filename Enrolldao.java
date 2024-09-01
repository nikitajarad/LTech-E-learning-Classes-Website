package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.model.Enroll;
import com.model.OTP;
import com.model.Register;
import com.model.SendOTP;

public class Enrolldao {
	Connection con=null;
	MyConnection mcon=new MyConnection();
	PreparedStatement pstate;
	int i=0;
	int flag=1;

	public int searchData(long phone,String otptxt,String course) {
		con=mcon.getConnection();
		long phoneNo = 0;
		String uname;
		String unames = null;
		int regId;
		String email;
		String otp = null;
		String courses;
		System.out.println(phone);
		try {
			pstate=con.prepareStatement("select * from RegisterInLTech where phone=?");
			pstate.setLong(1, phone);
			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				 regId=rs.getInt(1);
				 unames=rs.getString(2);
				 email=rs.getString(3);
				phoneNo=rs.getLong(4);
				System.out.println(phoneNo);
				SendOTP send=new SendOTP(Long.toString(phone));
				otp=send.getOtp();
					
					
				}
			if(phoneNo==phone && otptxt.equals(otp))
			{
				pstate=con.prepareStatement("select * from CheckForCourse where uname=?");
				pstate.setString(1, unames);
				ResultSet rs1=pstate.executeQuery();
				while(rs1.next())
				{
					 courses=rs1.getString(1);
					System.out.println(course);
					if(courses.equals(course)) {
						System.out.println("already present");
						flag=0;
						break;
					}
				}
				if(flag==1)
				{
					System.out.println("Hello"+course);
					pstate=con.prepareStatement("insert into CheckForCourse values(?,?)");
					pstate.setString(1, course);
					pstate.setString(2, unames);
					i=pstate.executeUpdate();
					if(i>0)
					{
						System.out.println("Successful.");
					}
				}
				else if(flag==0) {
					System.out.println("Already present");
					return i=-2;
				}
				else {
					System.out.println("Not found");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return i;
	}
}
