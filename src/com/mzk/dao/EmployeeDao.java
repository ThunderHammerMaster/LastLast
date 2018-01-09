package com.mzk.dao;

import com.mzk.entity.Employee;

public interface EmployeeDao {
	public Employee loginEmp(String empUser);
	public Employee queryIntvinfoEmp(Employee emp);
}
