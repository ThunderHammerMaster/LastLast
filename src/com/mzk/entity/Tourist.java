package com.mzk.entity;

public class Tourist {
	private int tId;
	private String tName;
	private String tPassword;
	private int tType;
	private int tResumeId;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettPassword() {
		return tPassword;
	}
	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}
	public int gettType() {
		return tType;
	}
	public void settType(int tType) {
		this.tType = tType;
	}
	public int gettResumeId() {
		return tResumeId;
	}
	public void settResumeId(int tResumeId) {
		this.tResumeId = tResumeId;
	}
	public Tourist(int tId, String tName, String tPassword, int tType, int tResumeId) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tPassword = tPassword;
		this.tType = tType;
		this.tResumeId = tResumeId;
	}
	public Tourist() {
		super();
	}
	@Override
	public String toString() {
		return "Tourist [tId=" + tId + ", tName=" + tName + ", tPassword=" + tPassword + ", tType=" + tType
				+ ", tResumeId=" + tResumeId + "]";
	}
	
	
}
