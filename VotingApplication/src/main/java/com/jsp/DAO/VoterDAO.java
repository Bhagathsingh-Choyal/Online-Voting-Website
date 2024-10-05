package com.jsp.DAO;

import java.util.List;

import com.jsp.model.Candidate;
import com.jsp.model.Voter;

public interface VoterDAO
{
	int voterRegistration(Voter voter);
	boolean voterlogin(String emailid,String password);
	boolean checkEmail(String email);
	Voter checkPassword(String email, String password);
	List<Candidate> fetchAllCandidates();
}
