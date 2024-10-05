package com.jsp.DAO;

import java.util.List;

import com.jsp.model.Admin;

public interface AdminDAO 
{
	boolean adminlogin(String emailid,String password);
	List<Admin> viewadmin();
}
