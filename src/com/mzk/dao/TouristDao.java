package com.mzk.dao;

import com.mzk.entity.Admin;
import com.mzk.entity.Employee;
import com.mzk.entity.Tourist;

public interface TouristDao {
	public void addTourist(Tourist tor);
	public Tourist queryTorByName(String tName);
	public Tourist loginQuery(Tourist tor);
	public Admin loginAdmin(String aName);
	public Employee loginEmp(String empUser);
	public void updatePassword(Tourist tor);
}
