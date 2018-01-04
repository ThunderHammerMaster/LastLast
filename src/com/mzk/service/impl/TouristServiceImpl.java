package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.TouristDao;
import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Tourist;
import com.mzk.service.TouristService;
@Service("touristService")
public class TouristServiceImpl implements TouristService{
	@Autowired
	private TouristDao touristDao;

	@Override
	public void addTourist(Tourist tor) {
		touristDao.addTourist(tor);
		
	}

	@Override
	public Tourist queryTorByName(String tName) {
		
		return touristDao.queryTorByName(tName);
	}

	@Override
	public Tourist loginQuery(Tourist tor) {
		
		return touristDao.loginQuery(tor);
	}

	@Override
	public void updatePassword(Tourist tor) {
		
		touristDao.updatePassword(tor);
	}

	@Override
	public List<Department> queryAllDepart() {
		
		return touristDao.queryAllDepart();
	}

	@Override
	public Tourist queryTorById(int id) {
		
		return touristDao.queryTorById(id);
	}

	@Override
	public void updateTorResume(Tourist tor) {
		touristDao.updateTorResume(tor);
		
	}

	
}
