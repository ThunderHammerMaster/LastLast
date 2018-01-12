package com.mzk.dao;

import com.mzk.entity.Employee;

public interface EmployeeDao {
	public Employee loginEmp(String empUser);
	public Employee queryIntvinfoEmp(Employee emp);
	public void addEmpInfo(int empId);
	public void delEmpInfo(int empId);
	public void admitEmp(Employee emp);
	public Employee queryEmpByEmpId(int empId);
	public Employee queryEmpByEmpName(String empName);
	public void updateEmpTrainInfo(Employee emp);
}
