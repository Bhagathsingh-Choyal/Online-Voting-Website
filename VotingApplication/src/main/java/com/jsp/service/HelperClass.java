package com.jsp.service;

import com.jsp.DAO.VoterDAO;
import com.jsp.DAO.VoterDAOImli;

public class HelperClass {

	public static VoterService helperMethodForVoterService() {
		
		VoterService service = new VoterServiceImpli();
		
		return service;
		
	}
	
	public static VoterDAO helperMethodForDAO() {
		
		VoterDAO dao = new VoterDAOImli();
		
		return dao;
		
	
	}
	
}
