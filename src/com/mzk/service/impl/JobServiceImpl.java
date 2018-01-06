package com.mzk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.JobDao;
import com.mzk.entity.Job;
import com.mzk.service.JobService;
@Service("jobService")
public class JobServiceImpl implements JobService{
	@Autowired
	private JobDao jobDao;

	@Override
	public void delJob(int id) {
		jobDao.delJob(id);
		
	}

	@Override
	public Job queryJobById(int id) {
		
		return jobDao.queryJobById(id);
	}

	@Override
	public void updateJobName(Job job) {
		jobDao.updateJobName(job);
		
	}

	@Override
	public void addJob(Job job) {
		jobDao.addJob(job);
		
	}

	@Override
	public void updateJobDepart(String name, int depId) {
		jobDao.updateJobDepart(name, depId);
		
	}

	
	
}
