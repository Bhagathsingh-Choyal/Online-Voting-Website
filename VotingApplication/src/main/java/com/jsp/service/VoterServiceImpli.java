package com.jsp.service;

import java.util.List;

import com.jsp.DAO.VoterDAO;
import com.jsp.model.Candidate;
import com.jsp.model.Voter;

import VoterException.VotersException;

public class VoterServiceImpli implements VoterService
{

	static VoterDAO vdao = HelperClass.helperMethodForDAO();
	
	@Override
	public boolean voterDataValidation(Voter voter) 
	{
		Voter voterdata = new Voter();
		String password = voter.getPassword();
		if(password.length()>=8)
		{
			voterdata.setPassword(password);
			String phonenumber = voter.getPhonenumber();
			if(phonenumber.length()==10)
			{
				voterdata.setPhonenumber(phonenumber);
				int age = voter.getAge();
				if(age>=18)
				{
					voterdata.setAge(age);
					voterdata.setVotername(voter.getVotername());
					voterdata.setEmailid(voter.getEmailid());
					voterdata.setAddress(voter.getAddress());
					voterdata.setImage(voter.getImage());
					VoterDAO forDAO = HelperClass.helperMethodForDAO();
					int voterRegistration = forDAO.voterRegistration(voterdata);
					
					if(voterRegistration!=0)
					{
						return true;
					}
					else
					{
						throw new VotersException("Server 404");
					}
				}
				else
				{
					throw new VotersException("Invalid Age");
				}
				
			}
			else
			{
				throw new VotersException("Invalid PhoneNumber");
			}
		}
		else
		{
			throw new VotersException("Invalid Password");
		}
	}

	@Override
	public Voter validateVoterLogin(String email, String password) {
		if(vdao.checkEmail(email))
		{
			Voter vtr = vdao.checkPassword(email, password);
			if(vtr!=null)
			{	
				return vtr;
			}
			else
			{
				throw new VotersException("Invalid Password");
			}
		}
		else
		{
			throw new VotersException("Invalid Email");
		}
	}

	@Override
	public List<Candidate> getAllCandidates() {
		
		List<Candidate> is = vdao.fetchAllCandidates();
		if(is!=null)
		{
			return is;
		}
		else
		{
			return null;
		}
		
	}

}
