package com.mzk.service;

import com.mzk.entity.Employee;

public interface EmployeeService {
	public Employee loginEmp(String empUser);
	public Employee queryIntvinfoEmp(Employee emp);
}
