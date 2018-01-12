package com.mzk.service;

import java.util.List;

import com.mzk.entity.Salarychange;

public interface SalarychangeService {
	public void addSalChange(Salarychange sal);
	public List<Salarychange> querySalchangeByEmpId(int empId);
}
