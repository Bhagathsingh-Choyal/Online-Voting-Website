package com.jsp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.DAO.VoterDAO;
import com.jsp.DAO.VoterDAOImli;
import com.jsp.model.Voter;
import com.jsp.service.HelperClass;
import com.jsp.service.VoterService;

import VoterException.VotersException;

@MultipartConfig
@WebServlet("/voterregistration")
public class VoterRegistration extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Voter voter = new Voter();
		voter.setVotername(request.getParameter("name"));
		voter.setEmailid(request.getParameter("email"));
		voter.setPassword(request.getParameter("password"));
		voter.setPhonenumber(request.getParameter("phone"));
		voter.setAddress(request.getParameter("address"));
		voter.setAge(Integer.parseInt(request.getParameter("age")));
		//To Fetch Image From FrontEnd
		Part file = request.getPart("image");
		InputStream is = file.getInputStream();
		byte[] img = is.readAllBytes();
		voter.setImage(img);
		
		HttpSession session =  request.getSession();
	
		VoterService service = HelperClass.helperMethodForVoterService();
		
		
		try {
			boolean validation = service.voterDataValidation(voter);
			RequestDispatcher dispatcher = request.getRequestDispatcher("VoterLogin.jsp");
			dispatcher.forward(request, response);
		} catch (VotersException e) {
			
			if(e.getMsg().equals("Server 404"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
			}
			else
			{	
				session.setAttribute("inv",e.getMsg());
				RequestDispatcher dispatcher = request.getRequestDispatcher("VoterRegistration.jsp");
				dispatcher.include(request, response);
			}
			
		}
	}
}
