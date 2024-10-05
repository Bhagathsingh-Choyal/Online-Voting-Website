package com.jsp.model;

import java.util.Arrays;

public class Voter 
{	
	private int voterid;
	private String votername;
	private String emailid;
	private String password;
	private String phonenumber;
	private String address;
	private int age;
	private byte[] image;
	private String status;
	
	public Voter() {}

	public Voter(int voterid, String votername, String emailid, String password, String phonenumber, String address,
			int age, byte[] image, String status) {
		super();
		this.voterid = voterid;
		this.votername = votername;
		this.emailid = emailid;
		this.password = password;
		this.phonenumber = phonenumber;
		this.address = address;
		this.age = age;
		this.image = image;
		this.status = status;
	}

	public int getVoterid() {
		return voterid;
	}

	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}

	public String getVotername() {
		return votername;
	}

	public void setVotername(String votername) {
		this.votername = votername;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voter [voterid=" + voterid + ", votername=" + votername + ", emailid=" + emailid + ", password="
				+ password + ", phonenumber=" + phonenumber + ", address=" + address + ", age=" + age + ", image="
				+ Arrays.toString(image) + ", status=" + status + "]";
	}

}
