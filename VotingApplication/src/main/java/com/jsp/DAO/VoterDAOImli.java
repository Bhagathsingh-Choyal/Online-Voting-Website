package com.jsp.DAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.model.Candidate;
import com.jsp.model.Voter;

public class VoterDAOImli implements VoterDAO
{
	private final static String url = "jdbc:mysql://localhost:3306/voterregistration?user=root&password=12345";
	private final static String voter_registration = "insert into voter(voter_name, voter_emailid, voter_password, voter_phonenumber, voter_address, voter_age,image,voter_status) values(?,?,?,?,?,?,?,?)";
	private final static String voter_login = "select * from voter where voter_emailid=? and voter_password=?";
	private final static String voter_email = "select * from voter where voter_emailid=?";
	private final static String all_candidates = "select * from candidate";
	
	@Override
	public int voterRegistration(Voter voter) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(voter_registration);
			ps.setString(1,voter.getVotername());
			ps.setString(2,voter.getEmailid());
			ps.setString(3,voter.getPassword());
			ps.setString(4,voter.getPhonenumber());
			ps.setString(5,voter.getAddress());
			ps.setInt(6,voter.getAge());
			ps.setBytes(7, voter.getImage());
			ps.setString(8, "NO");
			int result = ps.executeUpdate();
			if(result!=0)
			{
				return result;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean voterlogin(String emailid, String password) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(voter_login);
			ps.setString(1,emailid);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(voter_email);
			ps.setString(1,email);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Voter checkPassword(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(voter_login);
			ps.setString(1,email);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				Voter v = new Voter();
				v.setVoterid(result.getInt(1));
				v.setVotername(result.getString(2));
				v.setEmailid(result.getString(3));
				v.setPassword(result.getString(4));
				v.setPhonenumber(result.getString(5));
				v.setAddress(result.getString(6));
				v.setAge(result.getInt(7));
				v.setImage(result.getBytes(8));
				v.setStatus(result.getString(9));
				//To Store In The Class
				Blob b = result.getBlob(8);
				byte[] img =b.getBytes(1,(int)b.length());
				OutputStream os = new FileOutputStream("C:/super100/VotingApplication/src/main/webapp/Voterimage/"+v.getVotername().split(" ")[0]+".jpg");
				os.write(img);
				os.flush();
				os.close();
				
				
				return v;
			}
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> fetchAllCandidates() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(all_candidates);
			ResultSet rs = ps.executeQuery();
			List<Candidate> allcandi = new ArrayList<Candidate>();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Candidate c = new Candidate();
					c.setCid(rs.getInt(1));
					c.setName(rs.getString(2));
					c.setCage(rs.getInt(3));
					c.setCmobile(rs.getString(4));
					c.setCemail(rs.getString(5));
					c.setCsymbol(rs.getBytes(6));
					allcandi.add(c);
				}
				return allcandi;
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
