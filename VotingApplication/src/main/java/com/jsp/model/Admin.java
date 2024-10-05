package com.jsp.model;

public class Admin 
{
	private int adminid;
	private String adminname;
	private String emailid;
	private String password;
	
	public Admin() {}

	public Admin(int adminid,String adminname, String emailid, String password) 
	{
		this.adminid = adminid;
		this.adminname=adminname;
		this.emailid = emailid;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminName() {
		return adminname;
	}
	
	public void setAdminName(String adminname) {
		this.adminname = adminname;
	}
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() 
	{
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", emailid=" + emailid + ", password=" + password + "]";
	}
}
