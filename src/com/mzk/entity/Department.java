package com.mzk.entity;

import java.util.Date;
import java.util.List;

public class Department {
	private int departId;
	private String departName;
	private Date departCreatetime;
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
	public Date getDepartCreatetime() {
		return departCreatetime;
	}
	public void setDepartCreatetime(Date departCreatetime) {
		this.departCreatetime = departCreatetime;
	}
	public List<Job> getJob() {
		return job;
	}
	public void setJob(List<Job> job) {
		this.job = job;
	}
	public Department(int departId, String departName, Date departCreatetime, List<Job> job) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.departCreatetime = departCreatetime;
		this.job = job;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [departId=" + departId + ", departName=" + departName + ", departCreatetime="
				+ departCreatetime + ", job=" + job + "]";
	}
	
	
}
