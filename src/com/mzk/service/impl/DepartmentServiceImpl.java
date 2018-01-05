package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.DepartmentDao;
import com.mzk.entity.Department;
import com.mzk.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> queryAllDep() {
		
		return departmentDao.queryAllDep();
	}
}
