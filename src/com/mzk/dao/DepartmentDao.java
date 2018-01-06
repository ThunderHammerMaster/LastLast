package com.mzk.dao;

import java.util.List;

import com.mzk.entity.Department;

public interface DepartmentDao {
	public List<Department> queryAllDep();
	public void delDepartById(int id);
	public Department queryDepById(int id);
	public void updateDepart(Department dep);
	public void addDep(Department dep);
}
