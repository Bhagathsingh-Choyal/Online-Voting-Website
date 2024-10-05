package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.DAO.AdminDAO;
import com.jsp.DAO.AdminDAOImli;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailid = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminDAO dao = new AdminDAOImli();
		boolean result = dao.adminlogin(emailid, password);
		
		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		
		if(result==true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.include(request, response);
			writer.println("<center><h2>Invalid Credentials</h2></center>");
		}
	}
}
