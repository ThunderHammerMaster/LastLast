package com.mzk.entity;

import java.util.Date;

public class Interview {
	private int intvId;
	private String intvTitle;
	private String intvDepart;
	private String intvJob;
	private Date intvDate;
	private String intvDesc;
	public int getIntvId() {
		return intvId;
	}
	public void setIntvId(int intvId) {
		this.intvId = intvId;
	}
	public String getIntvTitle() {
		return intvTitle;
	}
	public void setIntvTitle(String intvTitle) {
		this.intvTitle = intvTitle;
	}
	public String getIntvDepart() {
		return intvDepart;
	}
	public void setIntvDepart(String intvDepart) {
		this.intvDepart = intvDepart;
	}
	public String getIntvJob() {
		return intvJob;
	}
	public void setIntvJob(String intvJob) {
		this.intvJob = intvJob;
	}
	public Date getIntvDate() {
		return intvDate;
	}
	public void setIntvDate(Date intvDate) {
		this.intvDate = intvDate;
	}
	public String getIntvDesc() {
		return intvDesc;
	}
	public void setIntvDesc(String intvDesc) {
		this.intvDesc = intvDesc;
	}
	public Interview(int intvId, String intvTitle, String intvDepart, String intvJob, Date intvDate, String intvDesc) {
		super();
		this.intvId = intvId;
		this.intvTitle = intvTitle;
		this.intvDepart = intvDepart;
		this.intvJob = intvJob;
		this.intvDate = intvDate;
		this.intvDesc = intvDesc;
	}
	public Interview() {
		super();
	}
	@Override
	public String toString() {
		return "Interview [intvId=" + intvId + ", intvTitle=" + intvTitle + ", intvDepart=" + intvDepart + ", intvJob="
				+ intvJob + ", intvDate=" + intvDate + ", intvDesc=" + intvDesc + "]";
	}
	
}
