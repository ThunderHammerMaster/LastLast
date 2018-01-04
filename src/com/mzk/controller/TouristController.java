package com.mzk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Tourist;
import com.mzk.service.AdminService;
import com.mzk.service.EmployeeService;
import com.mzk.service.TouristService;

@RequestMapping("/tor")
@Controller
public class TouristController {
	@Autowired
	private TouristService touristService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/toRegist")
	public String toRe() {
		return "redirect:/Regist.jsp";
	}
	
	@RequestMapping("/back")
	public String reBackHomePage() {
		return "redirect:/HomePage.jsp";
	}
	
	@RequestMapping("/regist")
	public String regist(Tourist tor) {
		touristService.addTourist(tor);
		
		return "redirect:/HomePage.jsp";
	}
	
	@RequestMapping("/checkName")
	@ResponseBody
	public String checkName(String tN) {
		Tourist tor=touristService.queryTorByName(tN);
		if(tor==null) {
			return "1";
		}else {
			return "0";
		}
	}
	
	@RequestMapping("/login")
	public String login(Tourist tor,Model model) {
		Tourist t=touristService.loginQuery(tor);
		if(t==null) {
			model.addAttribute("err", "用户名密码输入错误");
			return "forward:/HomePage.jsp";
		}
		List<Department> l=touristService.queryAllDepart();
		model.addAttribute("depart", l);
		if(t.gettType()==2) {
			model.addAttribute("type", "2");
			model.addAttribute("user",t);
		}else if(t.gettType()==1) {
			model.addAttribute("type", "1");
			Employee emp=employeeService.loginEmp(t.gettName());
			model.addAttribute("user", emp);
		}else if(t.gettType()==0) {
			model.addAttribute("type", "0");
			Admin admin=adminService.loginAdmin(t.gettName());
			model.addAttribute("user", admin);
		}
		return "User";
	}
	
	@RequestMapping("/updatePW")
	public String updatePassword(Tourist tor,Model model) {
		touristService.updatePassword(tor);
		model.addAttribute("tor", tor);
		return "forward:/tor/login";
	}
}
