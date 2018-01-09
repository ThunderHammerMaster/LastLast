package com.mzk.service;

import com.mzk.entity.Admin;

public interface AdminService {
	public Admin loginAdmin(String aName);
	public void addAdminInfo();
	public void delAdminInfo();
}
