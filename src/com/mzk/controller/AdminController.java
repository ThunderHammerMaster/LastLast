package com.mzk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mzk.entity.Interview;
import com.mzk.service.AdminService;
import com.mzk.service.InterviewService;
import com.mzk.util.MyUtil;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private InterviewService interviewService;
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@RequestMapping("/addIntv")
	public String addInterview(Interview intv,HttpSession session) {
		Date d=MyUtil.changeType(new Date());
		intv.setIntvDate(d);
		interviewService.addIntv(intv);
		List<Interview> l=interviewService.queryAllIntv();
		session.setAttribute("interview", l);
		return "Admin";
	}
}
