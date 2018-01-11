package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.InterviewinfoDao;
import com.mzk.entity.Interviewinfo;
import com.mzk.service.InterviewinfoService;
@Service("interviewinfoService")
public class InterviewinfoServiceImpl implements InterviewinfoService{
	@Autowired
	private InterviewinfoDao interviewinfoDao;

	@Override
	public void addInterviewinfo(Interviewinfo interviewinfo) {
		interviewinfoDao.addInterviewinfo(interviewinfo);
		
	}

	@Override
	public Interviewinfo quertIntvinfoByResId(int id) {
		
		return interviewinfoDao.quertIntvinfoByResId(id);
	}

	@Override
	public List<Interviewinfo> queryAllIntvinfo() {
		
		return interviewinfoDao.queryAllIntvinfo();
	}

	@Override
	public List<Interviewinfo> querytIntvinfoByEmpId(int empId) {
		
		return interviewinfoDao.querytIntvinfoByEmpId(empId);
	}

	@Override
	public Interviewinfo queryIntvinfoByInfoId(int intvinfoId) {
		
		return interviewinfoDao.queryIntvinfoByInfoId(intvinfoId);
	}

	@Override
	public void updateIntvinfoSee(Interviewinfo interviewinfo) {
		interviewinfoDao.updateIntvinfoSee(interviewinfo);
		
	}

	@Override
	public void delIntvinfo(int infoId) {
		interviewinfoDao.delIntvinfo(infoId);
		
	}

	@Override
	public void updateIntvinfoIntv(int intvinfoId) {
		interviewinfoDao.updateIntvinfoIntv(intvinfoId);
		
	}

	@Override
	public void updateIntvinfoSuccess(int intvinfoId) {
		interviewinfoDao.updateIntvinfoSuccess(intvinfoId);
		
	}

	@Override
	public List<Interviewinfo> queryIntvinfoByTorId(int torId) {
		
		return interviewinfoDao.queryIntvinfoByTorId(torId);
	}

	
}
