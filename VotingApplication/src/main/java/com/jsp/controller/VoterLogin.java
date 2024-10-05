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

import com.jsp.DAO.VoterDAO;
import com.jsp.DAO.VoterDAOImli;
import com.jsp.model.Candidate;
import com.jsp.model.Voter;
import com.jsp.service.HelperClass;
import com.jsp.service.VoterService;

import VoterException.VotersException;

@WebServlet("/voterlogin")
public class VoterLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		VoterService service = HelperClass.helperMethodForVoterService();
		
		try {
			Voter login = service.validateVoterLogin(email,password);
			List<Candidate> list = service.getAllCandidates();
			request.setAttribute("allcandi", list);
			request.setAttribute("vtr", login);
			System.out.println(login);
			RequestDispatcher dispatcher = request.getRequestDispatcher("VoterDashboard.jsp");
			dispatcher.include(request, response);
		}
		catch(VotersException e){
			HttpSession session = request.getSession();
			session.setAttribute("logVal",e.getMsg());
			RequestDispatcher dispatcher = request.getRequestDispatcher("VoterLogin.jsp");
			dispatcher.include(request, response);
		}
	}
}
