package com.mzk.entity;

public class Admin {
	private int aId;
	private String aName;
	private String aPassword;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	public Admin(int aId, String aName, String aPassword) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPassword = aPassword;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aPassword=" + aPassword + "]";
	}
	
}
