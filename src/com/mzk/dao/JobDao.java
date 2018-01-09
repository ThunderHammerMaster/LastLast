package com.mzk.dao;

import com.mzk.entity.Job;

public interface JobDao {
	public void delJob(int id);
	public Job queryJobById(int id);
	public void updateJobName(Job job);
	public void addJob(Job job);
	public void updateJobDepart(String name,int depId);
	public Job queryJobByName(String name);
}
