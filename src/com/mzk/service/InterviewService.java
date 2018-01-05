package com.mzk.service;

import java.util.List;

import com.mzk.entity.Interview;

public interface InterviewService {
	public void addIntv(Interview intv);
	public List<Interview> queryAllIntv();
	public void delIntv(int id);
	public Interview queryIntvById(int id);
	public void updateIntv(Interview intv);
}
