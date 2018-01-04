package com.mzk.service;

import java.util.List;

import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Tourist;

public interface TouristService {
	public void addTourist(Tourist tor);
	public Tourist queryTorByName(String tName);
	public Tourist loginQuery(Tourist tor);
	public void updatePassword(Tourist tor);
	public List<Department> queryAllDepart();
}
