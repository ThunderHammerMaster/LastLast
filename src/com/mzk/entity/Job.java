package com.mzk.entity;

import java.util.Date;
import java.util.List;

public class Job {
	private int jobId;
	private String jobName;
	private Date jobCreatetime;
	private List<Employee> emp;
	private int jobDepartId;
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
	public Date getJobCreatetime() {
		return jobCreatetime;
	}
	public void setJobCreatetime(Date jobCreatetime) {
		this.jobCreatetime = jobCreatetime;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public int getJobDepartId() {
		return jobDepartId;
	}
	public void setJobDepartId(int jobDepartId) {
		this.jobDepartId = jobDepartId;
	}
	public Job(int jobId, String jobName, Date jobCreatetime, List<Employee> emp, int jobDepartId) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobCreatetime = jobCreatetime;
		this.emp = emp;
		this.jobDepartId = jobDepartId;
	}
	public Job() {
		super();
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobCreatetime=" + jobCreatetime + ", emp=" + emp
				+ ", jobDepartId=" + jobDepartId + "]";
	}
	
	
}
