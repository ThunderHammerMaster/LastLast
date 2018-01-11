package com.mzk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mzk.entity.Employee;
import com.mzk.entity.Interviewinfo;
import com.mzk.entity.Job;
import com.mzk.entity.Resume;
import com.mzk.entity.Tourist;
import com.mzk.service.EmployeeService;
import com.mzk.service.InterviewinfoService;
import com.mzk.service.JobService;
import com.mzk.service.ResumeService;
import com.mzk.service.TouristService;

@RequestMapping("/emp")
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private InterviewinfoService interviewinfoService;
	@Autowired
	private TouristService touristService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private JobService jobService;
	
	@RequestMapping("backHome")
	public String backHomePage() {
		return "redirect:/HomePage.jsp";
	}
	
	@RequestMapping("admit")
	public String admitIntv(int infoId,int salary,HttpSession session) {
		Interviewinfo i=interviewinfoService.queryIntvinfoByInfoId(infoId);
		Tourist tor=touristService.queryTorById(i.getIntvinfoTorId());
		//先将游客表中的type改为员工类型
		touristService.torToEmp(i.getIntvinfoTorId());
		//主管提示信息减1
		Employee emp=(Employee)session.getAttribute("user");
		employeeService.delEmpInfo(emp.getEmpId());
		emp.setEmpInfo(emp.getEmpInfo()-1);
		session.setAttribute("user", emp);
		//添加一个员工信息到员工的数据库
		Resume r=resumeService.queryResumeById(i.getIntvinfoResId());
		Employee e=new Employee();
		Job j=jobService.queryJobByName(r.getrJob());
		e.setEmpUser(tor.gettName());
		e.setEmpPassword(tor.gettPassword());
		e.setEmpName(r.getrName());
		e.setEmpAge(r.getrAge());
		e.setEmpJobId(j.getJobId());
		e.setEmpDepartId(j.getJobDepartId());
		e.setEmpSalary(salary);
		employeeService.admitEmp(e);
		//将简历修改为已面试，并赋予员工编号
		e=employeeService.queryEmpByEmpName(tor.gettName());
		r.setrEmpId(e.getEmpId());
		resumeService.updateResAdmit(r);
		//设置应聘信息为已录取
		interviewinfoService.updateIntvinfoSuccess(infoId);
		List<Interviewinfo> ll=interviewinfoService.querytIntvinfoByEmpId(emp.getEmpId());
		session.setAttribute("intvinfo", ll);
		return "Employee";
	}
	
}
