package com.mzk.entity;

import java.util.Date;

public class Interviewinfo {
	private int intvinfoId;
	private Date intvinfoSendtime;
	private int intvinfoResId;
	private Date intvinfoIntvtime;
	private String intvinfoStatus;
	private int intvinfoIntvEmpId;
	private int intvinfoTorId;
	private String intvinfoIntv;
	private int intvinfoCheck;
	public int getIntvinfoId() {
		return intvinfoId;
	}
	public void setIntvinfoId(int intvinfoId) {
		this.intvinfoId = intvinfoId;
	}
	public Date getIntvinfoSendtime() {
		return intvinfoSendtime;
	}
	public void setIntvinfoSendtime(Date intvinfoSendtime) {
		this.intvinfoSendtime = intvinfoSendtime;
	}
	public int getIntvinfoResId() {
		return intvinfoResId;
	}
	public void setIntvinfoResId(int intvinfoResId) {
		this.intvinfoResId = intvinfoResId;
	}
	public Date getIntvinfoIntvtime() {
		return intvinfoIntvtime;
	}
	public void setIntvinfoIntvtime(Date intvinfoIntvtime) {
		this.intvinfoIntvtime = intvinfoIntvtime;
	}
	public String getIntvinfoStatus() {
		return intvinfoStatus;
	}
	public void setIntvinfoStatus(String intvinfoStatus) {
		this.intvinfoStatus = intvinfoStatus;
	}
	public int getIntvinfoIntvEmpId() {
		return intvinfoIntvEmpId;
	}
	public void setIntvinfoIntvEmpId(int intvinfoIntvEmpId) {
		this.intvinfoIntvEmpId = intvinfoIntvEmpId;
	}
	public int getIntvinfoTorId() {
		return intvinfoTorId;
	}
	public void setIntvinfoTorId(int intvinfoTorId) {
		this.intvinfoTorId = intvinfoTorId;
	}
	public String getIntvinfoIntv() {
		return intvinfoIntv;
	}
	public void setIntvinfoIntv(String intvinfoIntv) {
		this.intvinfoIntv = intvinfoIntv;
	}
	public int getIntvinfoCheck() {
		return intvinfoCheck;
	}
	public void setIntvinfoCheck(int intvinfoCheck) {
		this.intvinfoCheck = intvinfoCheck;
	}
	public Interviewinfo(int intvinfoId, Date intvinfoSendtime, int intvinfoResId, Date intvinfoIntvtime,
			String intvinfoStatus, int intvinfoIntvEmpId, int intvinfoTorId, String intvinfoIntv, int intvinfoCheck) {
		super();
		this.intvinfoId = intvinfoId;
		this.intvinfoSendtime = intvinfoSendtime;
		this.intvinfoResId = intvinfoResId;
		this.intvinfoIntvtime = intvinfoIntvtime;
		this.intvinfoStatus = intvinfoStatus;
		this.intvinfoIntvEmpId = intvinfoIntvEmpId;
		this.intvinfoTorId = intvinfoTorId;
		this.intvinfoIntv = intvinfoIntv;
		this.intvinfoCheck = intvinfoCheck;
	}
	public Interviewinfo() {
		super();
	}
	@Override
	public String toString() {
		return "Interviewinfo [intvinfoId=" + intvinfoId + ", intvinfoSendtime=" + intvinfoSendtime + ", intvinfoResId="
				+ intvinfoResId + ", intvinfoIntvtime=" + intvinfoIntvtime + ", intvinfoStatus=" + intvinfoStatus
				+ ", intvinfoIntvEmpId=" + intvinfoIntvEmpId + ", intvinfoTorId=" + intvinfoTorId + ", intvinfoIntv="
				+ intvinfoIntv + ", intvinfoCheck=" + intvinfoCheck + "]";
	}
	
	
	
	
}
