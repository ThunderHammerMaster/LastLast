package com.mzk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.ResumeDao;
import com.mzk.entity.Resume;
import com.mzk.service.ResumeService;
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeDao resumeDao;

	@Override
	public void addResume(Resume resume) {
		resumeDao.addResume(resume);
		
	}

	@Override
	public int queryResIdByName(String rName) {
		
		return resumeDao.queryResIdByName(rName);
	}

	@Override
	public Resume queryResumeByTorId(int tId) {
		
		return resumeDao.queryResumeByTorId(tId);
	}
}
