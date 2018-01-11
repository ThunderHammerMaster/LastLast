package com.mzk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.SignDao;
import com.mzk.entity.Sign;
import com.mzk.service.SignService;
@Service("signService")
public class SignServiceImpl implements SignService{
	@Autowired
	private SignDao signDao;

	@Override
	public void addSign(Sign sign) {
		signDao.addSign(sign);
		
	}

	@Override
	public Sign checkReSign(Sign sign) {
		
		return signDao.checkReSign(sign);
	}
}
