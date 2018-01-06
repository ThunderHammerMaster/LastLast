package com.mzk.service;

import java.util.List;

import com.mzk.entity.Department;

public interface DepartmentService {
	public List<Department> queryAllDep();
	public void delDepartById(int id);
	public Department queryDepById(int id);
	public void updateDepart(Department dep);
	public void addDep(Department dep);
}
