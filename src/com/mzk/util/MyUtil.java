package com.mzk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	public static Date changeType(Date d) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String day=sdf.format(d);
		try {
			d=sdf.parse(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static Date stringToDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d=null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
		
	}
}
