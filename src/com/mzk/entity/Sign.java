package com.mzk.entity;

import java.util.Date;

public class Sign {
	private int signId;
	private int signEmpId;
	private String signTime;
	private String signStatus;
	private Date signDate;
	public int getSignId() {
		return signId;
	}
	public void setSignId(int signId) {
		this.signId = signId;
	}
	public int getSignEmpId() {
		return signEmpId;
	}
	public void setSignEmpId(int signEmpId) {
		this.signEmpId = signEmpId;
	}
	public String getSignTime() {
		return signTime;
	}
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	public String getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public Sign(int signId, int signEmpId, String signTime, String signStatus, Date signDate) {
		super();
		this.signId = signId;
		this.signEmpId = signEmpId;
		this.signTime = signTime;
		this.signStatus = signStatus;
		this.signDate = signDate;
	}
	public Sign() {
		super();
	}
	@Override
	public String toString() {
		return "Sign [signId=" + signId + ", signEmpId=" + signEmpId + ", signTime=" + signTime + ", signStatus="
				+ signStatus + ", signDate=" + signDate + "]";
	}
	
}
