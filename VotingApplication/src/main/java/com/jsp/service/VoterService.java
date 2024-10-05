package com.jsp.service;

import java.util.List;

import com.jsp.model.Candidate;
import com.jsp.model.Voter;

public interface VoterService 
{
	boolean voterDataValidation(Voter voter);

	Voter validateVoterLogin(String email, String password);

	List<Candidate> getAllCandidates();
}
