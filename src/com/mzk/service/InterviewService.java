package com.mzk.service;

import java.util.List;

import com.mzk.entity.Interview;

public interface InterviewService {
	public void addIntv(Interview intv);
	public List<Interview> queryAllIntv();
}
