package com.mzk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.AdminDao;
import com.mzk.entity.Admin;
import com.mzk.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin loginAdmin(String aName) {
		
		return adminDao.loginAdmin(aName);
	}

	@Override
	public void addAdminInfo() {
		adminDao.addAdminInfo();
		
	}

	@Override
	public void delAdminInfo() {
		adminDao.delAdminInfo();
	}
}
