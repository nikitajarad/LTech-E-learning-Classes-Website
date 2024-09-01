package com.dao;
import java.util.*;

import javax.swing.JOptionPane;

import com.model.*;
import java.sql.*;
public class RegisterDao {
	Connection con=null;
	MyConnection mcon=new MyConnection();
	PreparedStatement pstate;
	int i;
	int regId;
	public int createRegister(Register rw)
	{
		con=mcon.getConnection();
		try {
			String sqlIdentifier = "select REGID.NEXTVAL from dual";
			pstate = con.prepareStatement(sqlIdentifier);
			synchronized( this ) {
			   ResultSet rs = pstate.executeQuery();
			   if(rs.next())
			     regId = rs.getInt(1);
			}
			pstate=con.prepareStatement("insert into RegisterInLTech values(?,?,?,?,?)");
			pstate.setInt(1, regId);
			pstate.setString(2, rw.getUname());
			pstate.setString(3, rw.getEmail());
			pstate.setLong(4, rw.getPhone());
			pstate.setString(5, rw.getPass());
			i=pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("Registration successfull.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
}