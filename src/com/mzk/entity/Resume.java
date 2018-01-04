package com.mzk.entity;

public class Resume {
	private int rId;
	private String rName;
	private String rSex;
	private int rAge;
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
	private String rUserName;
	//简历对应的游客编号
	private int rTorId;
	//简历对应的员工编号
	private int rEmpId;
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
	public int getrAge() {
		return rAge;
	}
	public void setrAge(int rAge) {
		this.rAge = rAge;
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
	public String getrUserName() {
		return rUserName;
	}
	public void setrUserName(String rUserName) {
		this.rUserName = rUserName;
	}
	public int getrTorId() {
		return rTorId;
	}
	public void setrTorId(int rTorId) {
		this.rTorId = rTorId;
	}
	public int getrEmpId() {
		return rEmpId;
	}
	public void setrEmpId(int rEmpId) {
		this.rEmpId = rEmpId;
	}
	public Resume(int rId, String rName, String rSex, int rAge, String rEducation, long rPhone, String rEmail,
			String rDepart, String rJob, String rOutlook, String rExperience, String rWantSalary, String rHobby,
			String rStatus, String rUserName, int rTorId, int rEmpId) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rSex = rSex;
		this.rAge = rAge;
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
		this.rUserName = rUserName;
		this.rTorId = rTorId;
		this.rEmpId = rEmpId;
	}
	public Resume() {
		super();
	}
	@Override
	public String toString() {
		return "Resume [rId=" + rId + ", rName=" + rName + ", rSex=" + rSex + ", rAge=" + rAge + ", rEducation="
				+ rEducation + ", rPhone=" + rPhone + ", rEmail=" + rEmail + ", rDepart=" + rDepart + ", rJob=" + rJob
				+ ", rOutlook=" + rOutlook + ", rExperience=" + rExperience + ", rWantSalary=" + rWantSalary
				+ ", rHobby=" + rHobby + ", rStatus=" + rStatus + ", rUserName=" + rUserName + ", rTorId=" + rTorId
				+ ", rEmpId=" + rEmpId + "]";
	}
	
	
}
