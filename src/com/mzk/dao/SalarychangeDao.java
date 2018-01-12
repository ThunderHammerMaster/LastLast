package com.mzk.dao;

import java.util.List;

import com.mzk.entity.Salarychange;

public interface SalarychangeDao {
	public void addSalChange(Salarychange sal);
	public List<Salarychange> querySalchangeByEmpId(int empId);
}
