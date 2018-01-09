package com.mzk.dao;

import com.mzk.entity.Admin;

public interface AdminDao {
	public Admin loginAdmin(String aName);
	public void addAdminInfo();
	public void delAdminInfo();
}
