package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.InterviewDao;
import com.mzk.entity.Interview;
import com.mzk.service.InterviewService;
@Service("interviewService")
public class InterviewServiceImpl implements InterviewService{
	@Autowired
	private InterviewDao interviewDao;

	@Override
	public void addIntv(Interview intv) {
		interviewDao.addIntv(intv);
		
	}

	@Override
	public List<Interview> queryAllIntv() {
		
		return interviewDao.queryAllIntv();
	}

	@Override
	public void delIntv(int id) {
		interviewDao.delIntv(id);
		
	}

	@Override
	public Interview queryIntvById(int id) {
		
		return interviewDao.queryIntvById(id);
	}

	@Override
	public void updateIntv(Interview intv) {
		interviewDao.updateIntv(intv);
		
	}
}
