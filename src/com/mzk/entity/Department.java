package com.mzk.entity;

import java.util.List;

public class Department {
	private int departId;
	private String depatName;
	private List<Job> job;
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepatName() {
		return depatName;
	}
	public void setDepatName(String depatName) {
		this.depatName = depatName;
	}
	public List<Job> getJob() {
		return job;
	}
	public void setJob(List<Job> job) {
		this.job = job;
	}
	public Department(int departId, String depatName, List<Job> job) {
		super();
		this.departId = departId;
		this.depatName = depatName;
		this.job = job;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [departId=" + departId + ", depatName=" + depatName + ", job=" + job + "]";
	}
	
	
}
