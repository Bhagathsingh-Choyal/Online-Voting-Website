package com.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.jsp.model.Admin;

public class AdminDAOImli implements AdminDAO
{
	private final static String url = "jdbc:mysql://localhost:3306/voterregistration?user=root&password=12345";
	private final static String admin_login = "select * from admin where admin_emailid=? and admin_password=?";
	private final static String view_admin = "select * from admin";

	
	@Override
	public boolean adminlogin(String emailid, String password) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(admin_login);
			ps.setString(1,emailid);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}


	@Override
	public List<Admin> viewadmin() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(view_admin);
			ResultSet result = ps.executeQuery();
			
			List<Admin> list = new ArrayList<Admin>();
			
			if(result.isBeforeFirst())
			{	
				while(result.next())
				{
					Admin admin = new Admin(result.getInt("adminid"),result.getString("adminname"),result.getString("emailid"),result.getString("password"));
					list.add(admin);
				}
				return list;
			}
			else
			{
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
