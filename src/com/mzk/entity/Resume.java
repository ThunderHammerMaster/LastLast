package com.mzk.entity;

public class Resume {
	private int rId;
	private String rName;
	private String rSex;
	private String rEducation;
	private long rPhone;
	private String rEmail;
	private String rDepart;
	private String rJob;
	private String rOutlook;
	private String rExperience;
	private String rWantSalary;
	private String rHobby;
	private String rStatus;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrSex() {
		return rSex;
	}
	public void setrSex(String rSex) {
		this.rSex = rSex;
	}
	public String getrEducation() {
		return rEducation;
	}
	public void setrEducation(String rEducation) {
		this.rEducation = rEducation;
	}
	public long getrPhone() {
		return rPhone;
	}
	public void setrPhone(long rPhone) {
		this.rPhone = rPhone;
	}
	public String getrEmail() {
		return rEmail;
	}
	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}
	public String getrDepart() {
		return rDepart;
	}
	public void setrDepart(String rDepart) {
		this.rDepart = rDepart;
	}
	public String getrJob() {
		return rJob;
	}
	public void setrJob(String rJob) {
		this.rJob = rJob;
	}
	public String getrOutlook() {
		return rOutlook;
	}
	public void setrOutlook(String rOutlook) {
		this.rOutlook = rOutlook;
	}
	public String getrExperience() {
		return rExperience;
	}
	public void setrExperience(String rExperience) {
		this.rExperience = rExperience;
	}
	public String getrWantSalary() {
		return rWantSalary;
	}
	public void setrWantSalary(String rWantSalary) {
		this.rWantSalary = rWantSalary;
	}
	public String getrHobby() {
		return rHobby;
	}
	public void setrHobby(String rHobby) {
		this.rHobby = rHobby;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public Resume(int rId, String rName, String rSex, String rEducation, long rPhone, String rEmail, String rDepart,
			String rJob, String rOutlook, String rExperience, String rWantSalary, String rHobby, String rStatus) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rSex = rSex;
		this.rEducation = rEducation;
		this.rPhone = rPhone;
		this.rEmail = rEmail;
		this.rDepart = rDepart;
		this.rJob = rJob;
		this.rOutlook = rOutlook;
		this.rExperience = rExperience;
		this.rWantSalary = rWantSalary;
		this.rHobby = rHobby;
		this.rStatus = rStatus;
	}
	public Resume() {
		super();
	}
	@Override
	public String toString() {
		return "Resume [rId=" + rId + ", rName=" + rName + ", rSex=" + rSex + ", rEducation=" + rEducation + ", rPhone="
				+ rPhone + ", rEmail=" + rEmail + ", rDepart=" + rDepart + ", rJob=" + rJob + ", rOutlook=" + rOutlook
				+ ", rExperience=" + rExperience + ", rWantSalary=" + rWantSalary + ", rHobby=" + rHobby + ", rStatus="
				+ rStatus + "]";
	}
	
	
}
