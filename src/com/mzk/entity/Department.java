package com.mzk.entity;

import java.util.List;

public class Department {
	private int departId;
	private String departName;
	private List<Job> job;
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public List<Job> getJob() {
		return job;
	}
	public void setJob(List<Job> job) {
		this.job = job;
	}
	public Department(int departId, String departName, List<Job> job) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.job = job;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [departId=" + departId + ", departName=" + departName + ", job=" + job + "]";
	}
	
	
	
}
