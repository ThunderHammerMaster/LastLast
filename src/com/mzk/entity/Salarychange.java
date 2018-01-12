package com.mzk.entity;

import java.util.Date;

public class Salarychange {
	private int salchangeId;
	private int salchangeEmpId;
	private Date salchangeDate;
	private int salchangeNum;
	private String salchangeReason;
	private int salchangeYear;
	private int salchangeMonth;
	public int getSalchangeId() {
		return salchangeId;
	}
	public void setSalchangeId(int salchangeId) {
		this.salchangeId = salchangeId;
	}
	public int getSalchangeEmpId() {
		return salchangeEmpId;
	}
	public void setSalchangeEmpId(int salchangeEmpId) {
		this.salchangeEmpId = salchangeEmpId;
	}
	public Date getSalchangeDate() {
		return salchangeDate;
	}
	public void setSalchangeDate(Date salchangeDate) {
		this.salchangeDate = salchangeDate;
	}
	public int getSalchangeNum() {
		return salchangeNum;
	}
	public void setSalchangeNum(int salchangeNum) {
		this.salchangeNum = salchangeNum;
	}
	public String getSalchangeReason() {
		return salchangeReason;
	}
	public void setSalchangeReason(String salchangeReason) {
		this.salchangeReason = salchangeReason;
	}
	public int getSalchangeYear() {
		return salchangeYear;
	}
	public void setSalchangeYear(int salchangeYear) {
		this.salchangeYear = salchangeYear;
	}
	public int getSalchangeMonth() {
		return salchangeMonth;
	}
	public void setSalchangeMonth(int salchangeMonth) {
		this.salchangeMonth = salchangeMonth;
	}
	public Salarychange(int salchangeId, int salchangeEmpId, Date salchangeDate, int salchangeNum,
			String salchangeReason, int salchangeYear, int salchangeMonth) {
		super();
		this.salchangeId = salchangeId;
		this.salchangeEmpId = salchangeEmpId;
		this.salchangeDate = salchangeDate;
		this.salchangeNum = salchangeNum;
		this.salchangeReason = salchangeReason;
		this.salchangeYear = salchangeYear;
		this.salchangeMonth = salchangeMonth;
	}
	public Salarychange() {
		super();
	}
	@Override
	public String toString() {
		return "Salarychange [salchangeId=" + salchangeId + ", salchangeEmpId=" + salchangeEmpId + ", salchangeDate="
				+ salchangeDate + ", salchangeNum=" + salchangeNum + ", salchangeReason=" + salchangeReason
				+ ", salchangeYear=" + salchangeYear + ", salchangeMonth=" + salchangeMonth + "]";
	}
	
	
}
