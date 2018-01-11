package com.mzk.dao;

import com.mzk.entity.Sign;

public interface SignDao {
	public void addSign(Sign sign);
	public Sign checkReSign(Sign sign);
}
