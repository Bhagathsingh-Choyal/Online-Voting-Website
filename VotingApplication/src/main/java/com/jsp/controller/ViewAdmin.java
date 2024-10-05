package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.AdminDAO;
import com.jsp.DAO.AdminDAOImli;
import com.jsp.model.Admin;

@WebServlet("/viewadmin")
public class ViewAdmin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminDAO dao = new AdminDAOImli();
		List<Admin> viewadmin = dao.viewadmin();
		
		HttpSession session = request.getSession();
		
		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		
		if(viewadmin.size()!=0)
		{
			session.setAttribute("viewadmindetails",viewadmin);
			writer.println("Successfull");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAdmin.jsp");
			dispatcher.include(request, response);
		}
		else
		{
			
		}
	}
}
