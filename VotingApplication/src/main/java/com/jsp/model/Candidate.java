package com.jsp.model;

import java.util.Arrays;

public class Candidate {
	
	private int cid;
	private String name;
	private int cage;
	private String cmobile;
	private String cemail;
	private byte[] csymbol;
	public Candidate() {
		super();
	}
	public Candidate(int cid, String name, int cage, String cmobile, String cemail, byte[] csymbol) {
		super();
		this.cid = cid;
		this.name = name;
		this.cage = cage;
		this.cmobile = cmobile;
		this.cemail = cemail;
		this.csymbol = csymbol;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public byte[] getCsymbol() {
		return csymbol;
	}
	public void setCsymbol(byte[] csymbol) {
		this.csymbol = csymbol;
	}
	@Override
	public String toString() {
		return "Candidate [cid=" + cid + ", name=" + name + ", cage=" + cage + ", cmobile=" + cmobile + ", cemail="
				+ cemail + ", csymbol=" + Arrays.toString(csymbol) + "]";
	}
	
	
}
