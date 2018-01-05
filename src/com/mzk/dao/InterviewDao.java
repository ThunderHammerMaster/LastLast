package com.mzk.dao;

import java.util.List;

import com.mzk.entity.Interview;

public interface InterviewDao {
	public void addIntv(Interview intv);
	public List<Interview> queryAllIntv();
}
