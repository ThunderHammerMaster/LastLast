package com.mzk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.EmployeeDao;
import com.mzk.entity.Employee;
import com.mzk.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee loginEmp(String empUser) {
		
		return employeeDao.loginEmp(empUser);
	}

	@Override
	public Employee queryIntvinfoEmp(Employee emp) {
		
		return employeeDao.queryIntvinfoEmp(emp);
	}

	@Override
	public void addEmpInfo(int empId) {
		employeeDao.addEmpInfo(empId);
		
	}

	@Override
	public void delEmpInfo(int empId) {
		employeeDao.delEmpInfo(empId);
		
	}

	@Override
	public void admitEmp(Employee emp) {
		employeeDao.admitEmp(emp);
		
	}

	@Override
	public Employee queryEmpByEmpId(int empId) {
		
		return employeeDao.queryEmpByEmpId(empId);
	}

	@Override
	public Employee queryEmpByEmpName(String empName) {
		
		return employeeDao.queryEmpByEmpName(empName);
	}

	@Override
	public void updateEmpTrainInfo(Employee emp) {
		
		employeeDao.updateEmpTrainInfo(emp);
	}
}
