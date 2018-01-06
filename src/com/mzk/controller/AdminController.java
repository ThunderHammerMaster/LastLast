package com.mzk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzk.entity.Department;
import com.mzk.entity.Interview;
import com.mzk.entity.Job;
import com.mzk.service.AdminService;
import com.mzk.service.DepartmentService;
import com.mzk.service.InterviewService;
import com.mzk.service.JobService;
import com.mzk.util.MyUtil;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private JobService jobService;
	
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
	
	@RequestMapping("delIntv")
	public String delInterview(int delIntvId,HttpSession session) {
		interviewService.delIntv(delIntvId);
		List<Interview> l=interviewService.queryAllIntv();
		session.setAttribute("interview", l);
		return "Admin";
	}
	
	@RequestMapping("toEditIntv")
	public String toEditInterview(int editIntvId,Model model) {
		Interview i=interviewService.queryIntvById(editIntvId);
		model.addAttribute("editIntv", i);
		return "EditIntv";
	}
	
	@RequestMapping("editIntv")
	public String editInterview(Interview intv,HttpSession session) {
		interviewService.updateIntv(intv);
		List<Interview> l=interviewService.queryAllIntv();
		session.setAttribute("interview", l);
		return "Admin";
	}
	
	@RequestMapping("back")
	public String backAdmin() {
		return "Admin";
	}
	
	@RequestMapping("delDepart")
	@ResponseBody
	public String deleteDepart(int delDepartId,HttpSession session) {
		Department dep=departmentService.queryDepById(delDepartId);
		if(dep.getJob().size()==0) {
			departmentService.delDepartById(delDepartId);
			List<Department> l=departmentService.queryAllDep();
			session.setAttribute("depart", l);
			return "1";
		}else {
			return "0";
		}
		
	}
	
	@RequestMapping("backHome")
	public String backHome() {
		return "redirect:/HomePage.jsp";
	}
	
	@RequestMapping("editDepart")
	@ResponseBody
	public String editDepName(Department dep,HttpSession session) {
		departmentService.updateDepart(dep);
		List<Department> l=departmentService.queryAllDep();
		session.setAttribute("depart", l);
		return "1";
	}
	
	@RequestMapping("delJob")
	@ResponseBody
	public String deleteJob(int delJobId,HttpSession session) {
		Job j=jobService.queryJobById(delJobId);
		if(j.getEmp().size()==0) {
			jobService.delJob(delJobId);
			List<Department> l=departmentService.queryAllDep();
			session.setAttribute("depart", l);
			return "1";
		}
		return "2";
	}
	
	@RequestMapping("editJob")
	@ResponseBody
	public String updateJobName(Job job,HttpSession session) {
		jobService.updateJobName(job);
		List<Department> l=departmentService.queryAllDep();
		session.setAttribute("depart", l);
		return "1";
	}
	
	@RequestMapping("toAddDJ")
	public String toAddDepJob(int type,Model model) {
		model.addAttribute("type", type);
		return "AddDepOrJob";
	}
	
	@RequestMapping("addDep")
	public String addDepartment(Department dep,HttpSession session) {
		Date d=new Date();
		d=MyUtil.changeType(d);
		dep.setDepartCreatetime(d);
		departmentService.addDep(dep);
		List<Department> l=departmentService.queryAllDep();
		session.setAttribute("depart", l);
		return "Admin";
	}
	
	@RequestMapping("addJob")
	public String addJob(Job job,int jobDepartId,HttpSession session) {
		Date d=new Date();
		d=MyUtil.changeType(d);
		job.setJobCreatetime(d);
		jobService.addJob(job);
		jobService.updateJobDepart(job.getJobName(), jobDepartId);
		List<Department> l=departmentService.queryAllDep();
		session.setAttribute("depart", l);
		return "Admin";
	}
}
