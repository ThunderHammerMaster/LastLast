package com.mzk.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mzk.entity.Employee;
import com.mzk.entity.Interviewinfo;
import com.mzk.entity.Job;
import com.mzk.entity.Resume;
import com.mzk.entity.Sign;
import com.mzk.entity.Tourist;
import com.mzk.service.EmployeeService;
import com.mzk.service.InterviewinfoService;
import com.mzk.service.JobService;
import com.mzk.service.ResumeService;
import com.mzk.service.SignService;
import com.mzk.service.TouristService;
import com.mzk.util.MyUtil;

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
	@Autowired
	private SignService signService;
	
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
	
	@RequestMapping("intvFail")
	public String intvcheckFail(int infoId,HttpSession session) {
		Interviewinfo i=interviewinfoService.queryIntvinfoByInfoId(infoId);
		Tourist tor=new Tourist();
		tor.settId(i.getIntvinfoTorId());
		//主管提示信息减1
		Employee emp=(Employee)session.getAttribute("user");
		employeeService.delEmpInfo(emp.getEmpId());
		emp.setEmpInfo(emp.getEmpInfo()-1);
		session.setAttribute("user", emp);
		//通知内容刷新，把应聘信息改为未通过面试
		interviewinfoService.delIntvinfo(infoId);
		List<Interviewinfo> ll=interviewinfoService.querytIntvinfoByEmpId(emp.getEmpId());
		session.setAttribute("intvinfo", ll);
		//简历状态改为未通过面试
		resumeService.updateResfail(i.getIntvinfoResId());
		//把应聘信息改为未通过面试
		interviewinfoService.updateIntvinfoSuccess(infoId);
		interviewinfoService.delIntvinfo(infoId);
		//通知游客未通过面试
		touristService.addTorInfo(tor);
		return "Employee";
	}
	
	@RequestMapping("signMorning")
	public String signMor(HttpSession session) {
		Employee emp=(Employee) session.getAttribute("user");
		Date d=new Date();
		int hour=d.getHours();
		d=MyUtil.changeType(d);
		Sign s= new Sign();
		s.setSignEmpId(emp.getEmpId());
		s.setSignTime("早");
		s.setSignDate(d);
		//超过打卡时间
		if(hour>=10) {
			s.setSignStatus("迟到打卡");
		}else {
			s.setSignStatus("正常打卡");
		}
		//检查有没有重复打卡
		Sign cs=signService.checkReSign(s);
		if(cs==null) {
			signService.addSign(s);
		}
		return "Employee";
	}
	
	@RequestMapping("signAfternoon")
	public String signAft(HttpSession session) {
		Employee emp=(Employee) session.getAttribute("user");
		Date d=new Date();
		int hour=d.getHours();
		d=MyUtil.changeType(d);
		Sign s= new Sign();
		s.setSignEmpId(emp.getEmpId());
		s.setSignTime("晚");
		s.setSignDate(d);
		//超过打卡时间
		if(hour>=10) {
			s.setSignStatus("迟到打卡");
		}else {
			s.setSignStatus("正常打卡");
		}
		//检查有没有重复打卡
		Sign cs=signService.checkReSign(s);
		if(cs==null) {
			signService.addSign(s);
		}
		return "Employee";
	}
	
}
