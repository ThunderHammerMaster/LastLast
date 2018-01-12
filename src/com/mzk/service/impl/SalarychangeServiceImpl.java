package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.SalarychangeDao;
import com.mzk.entity.Salarychange;
import com.mzk.service.SalarychangeService;
@Service("salarychangeService")
public class SalarychangeServiceImpl implements SalarychangeService{
	@Autowired
	private SalarychangeDao salarychangeDao;

	@Override
	public void addSalChange(Salarychange sal) {
		salarychangeDao.addSalChange(sal);
		
	}

	@Override
	public List<Salarychange> querySalchangeByEmpId(int empId) {
		return salarychangeDao.querySalchangeByEmpId(empId);
	}

	
}
