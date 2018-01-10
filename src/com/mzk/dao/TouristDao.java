package com.mzk.dao;

import java.util.List;

import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Tourist;

public interface TouristDao {
	public void addTourist(Tourist tor);
	public Tourist queryTorByName(String tName);
	public Tourist loginQuery(Tourist tor);
	public void updatePassword(Tourist tor);
	public Tourist queryTorById(int id);
	public void updateTorResume(Tourist tor);
	public void addTorInfo(Tourist tor);
	public void delTorInfo(Tourist tor);
	public void torToEmp(int torId);
}
