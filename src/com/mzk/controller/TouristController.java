package com.mzk.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Interview;
import com.mzk.entity.Interviewinfo;
import com.mzk.entity.Resume;
import com.mzk.entity.Salarychange;
import com.mzk.entity.Tourist;
import com.mzk.service.AdminService;
import com.mzk.service.DepartmentService;
import com.mzk.service.EmployeeService;
import com.mzk.service.InterviewService;
import com.mzk.service.InterviewinfoService;
import com.mzk.service.ResumeService;
import com.mzk.service.SalarychangeService;
import com.mzk.service.TouristService;
import com.mzk.util.MyUtil;

@RequestMapping("/tor")
@Controller
public class TouristController {
	@Autowired
	private TouristService touristService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private InterviewinfoService interviewinfoService;
	@Autowired
	private SalarychangeService salarychangeService;
	
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
	public String login(Tourist tor,Model model,HttpSession session) {
		Tourist t=touristService.loginQuery(tor);
		if(t==null) {
			model.addAttribute("err", "用户名密码输入错误");
			return "forward:/HomePage.jsp";
		}
		//将招聘信息放进session
		List<Interview> li=interviewService.queryAllIntv();
		session.setAttribute("interview", li);
		//将部门放进session
		List<Department> l=departmentService.queryAllDep();
		session.setAttribute("depart", l);
		//将简历放进session
		Resume resume=resumeService.queryResumeByTorId(t.gettId());
		session.setAttribute("myResume", resume);
		if(t.gettType()==2) {
			session.setAttribute("user",t);
			if(resume!=null) {
				//游客需要看到自己的应聘信息
				Interviewinfo intv=interviewinfoService.quertIntvinfoByResId(resume.getrId());
				session.setAttribute("intvinfo", intv);
			}
			if(resume==null) {
				List<Interviewinfo> i=interviewinfoService.queryIntvinfoByTorId(t.gettId());
				if(i.size()>0) {
					int maxId=0;
					for (Interviewinfo intv : i) {
						if(intv.getIntvinfoId()>maxId) {
							maxId=intv.getIntvinfoId();
						}
					}
					Interviewinfo intv =interviewinfoService.queryIntvinfoByInfoId(maxId);
					session.setAttribute("intvinfoo", intv);
				}
				
			}
			return "User";
		}else if(t.gettType()==1) {
			Employee emp=employeeService.loginEmp(t.gettName());
			session.setAttribute("user", emp);
			//主管需要看到他要面试的人的应聘信息
			List<Interviewinfo> ll=interviewinfoService.querytIntvinfoByEmpId(emp.getEmpId());
			session.setAttribute("intvinfo", ll);
			//将奖惩信息存入session
			List<Salarychange> ls=salarychangeService.querySalchangeByEmpId(emp.getEmpId());
			session.setAttribute("salchange", ls);
			return "Employee";
		}else{
			Admin admin=adminService.loginAdmin(t.gettName());
			session.setAttribute("user", admin);
			//管理员需要看到游客还未面试且自己还未检查的应聘信息
			List<Interviewinfo> ll=interviewinfoService.queryAllIntvinfo();
			session.setAttribute("intvinfo", ll);
			return "Admin";
		}
		
	}
	
	@RequestMapping("/updatePW")
	public String updatePassword(Tourist tor,HttpSession session) {
		touristService.updatePassword(tor);
		session.setAttribute("user", tor);
		return "User";
	}
	
	@RequestMapping("/sendResume")
	public String sendRes(Resume resume,int sRId,HttpSession session) {
		Tourist tor=touristService.queryTorById(sRId);
		resume.setrTorId(tor.gettId());
		resume.setrUserName(tor.gettName());
		//添加简历到简历的数据库
		resumeService.addResume(resume);
		//查找简历自动生成的简历Id
		int resId=resumeService.queryResIdByName(resume.getrName());
		tor.settResumeId(resId);
		resume.setrId(resId);
		//修改数据库中游客对应的简历Id
		touristService.updateTorResume(tor);
		session.setAttribute("user", tor);
		session.setAttribute("myResume", resume);
		return "User";
	}
	
	@RequestMapping("/updateRes")
	public String updateResume(Resume resume,String urDepart,String urJob,HttpSession session) {
		Resume res=(Resume) session.getAttribute("myResume");
		resume.setrDepart(urDepart);
		resume.setrJob(urJob);
		resume.setrId(res.getrId());
		resumeService.updateResume(resume);
		res=resumeService.queryResumeById(res.getrId());
		session.setAttribute("myResume", res);
		return "User";
	}
	
	@RequestMapping("sendRes")
	public String sendResume(HttpSession session) {
		Resume res=(Resume) session.getAttribute("myResume");
		Tourist t=(Tourist) session.getAttribute("user");
		//不能重复提交
		if(interviewinfoService.quertIntvinfoByResId(res.getrId())==null) {
			Interviewinfo interviewinfo=new Interviewinfo();
			Date d=new Date();
			d=MyUtil.changeType(d);
			interviewinfo.setIntvinfoSendtime(d);
			interviewinfo.setIntvinfoResId(res.getrId());
			interviewinfo.setIntvinfoTorId(t.gettId());
			interviewinfoService.addInterviewinfo(interviewinfo);
			adminService.addAdminInfo();
		}
		return "User";
	}
	
	@RequestMapping("goIntv")
	public String torIntv(int intvinfoId,HttpSession session) {
		Interviewinfo i=interviewinfoService.queryIntvinfoByInfoId(intvinfoId);
		if(i.getIntvinfoIntv().equals("未面试")) {
			//游客收到消息减少并更新session
			Tourist tor=(Tourist) session.getAttribute("user");
			touristService.delTorInfo(tor);
			tor.settInfo(tor.gettInfo()-1);
			session.setAttribute("user", tor);
			//将应聘信息更新为已面试
			interviewinfoService.updateIntvinfoIntv(intvinfoId);
			i.setIntvinfoIntv("已面试");
			session.setAttribute("intvinfo", i);
			//通知主管有面试信息
			employeeService.addEmpInfo(i.getIntvinfoIntvEmpId());
		}
		return "User";
	}
	
	@RequestMapping("checkFailInfo")
	public String checkFailInfo(HttpSession session) {
		Tourist tor=(Tourist) session.getAttribute("user");
		if(tor.gettInfo()>0) {
			touristService.delTorInfo(tor);
			tor.settInfo(tor.gettInfo()-1);
			session.setAttribute("user", tor);
		}
		return "User";
	}

}
