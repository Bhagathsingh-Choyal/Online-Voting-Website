package com.jsp.model;

public class LiveVoting 
{
	private int id;
	private int candidateid;
	private int totalvotes;
	
	public LiveVoting() {}

	public LiveVoting(int id, int candidateid, int totalvotes) {
		super();
		this.id = id;
		this.candidateid = candidateid;
		this.totalvotes = totalvotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}

	public int getTotalvotes() {
		return totalvotes;
	}

	public void setTotalvotes(int totalvotes) {
		this.totalvotes = totalvotes;
	}

	@Override
	public String toString() {
		return "LiveVoting [id=" + id + ", candidateid=" + candidateid + ", totalvotes=" + totalvotes + "]";
	}
	
	
}
