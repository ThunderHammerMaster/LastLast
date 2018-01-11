package com.mzk.service;

import java.util.List;

import com.mzk.entity.Interviewinfo;

public interface InterviewinfoService {
	public void addInterviewinfo(Interviewinfo interviewinfo);
	public Interviewinfo quertIntvinfoByResId(int id);
	public List<Interviewinfo> queryAllIntvinfo();
	public List<Interviewinfo> querytIntvinfoByEmpId(int empId);
	public Interviewinfo queryIntvinfoByInfoId(int intvinfoId);
	public void updateIntvinfoSee(Interviewinfo interviewinfo);
	public void delIntvinfo(int infoId);
	public void updateIntvinfoIntv(int intvinfoId);
	public void updateIntvinfoSuccess(int intvinfoId);
	public List<Interviewinfo> queryIntvinfoByTorId(int torId);

}
