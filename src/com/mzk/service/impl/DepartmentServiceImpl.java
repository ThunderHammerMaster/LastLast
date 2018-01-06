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

	@Override
	public void delDepartById(int id) {
		departmentDao.delDepartById(id);
		
	}

	@Override
	public Department queryDepById(int id) {
		
		return departmentDao.queryDepById(id);
	}

	@Override
	public void updateDepart(Department dep) {
		departmentDao.updateDepart(dep);
		
	}

	@Override
	public void addDep(Department dep) {
		departmentDao.addDep(dep);
	}
}
