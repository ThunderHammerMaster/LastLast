package com.mzk.entity;

import java.util.List;

public class Job {
	private int jobId;
	private String jobName;
	private Department depart;
	private List<Employee> emp;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public Job(int jobId, String jobName, Department depart, List<Employee> emp) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.depart = depart;
		this.emp = emp;
	}
	public Job() {
		super();
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", emp=" + emp + "]";
	}
	
	
	
}
