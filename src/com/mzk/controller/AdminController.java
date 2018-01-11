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

import com.mzk.entity.Admin;
import com.mzk.entity.Department;
import com.mzk.entity.Employee;
import com.mzk.entity.Interview;
import com.mzk.entity.Interviewinfo;
import com.mzk.entity.Job;
import com.mzk.entity.Resume;
import com.mzk.entity.Tourist;
import com.mzk.service.AdminService;
import com.mzk.service.DepartmentService;
import com.mzk.service.EmployeeService;
import com.mzk.service.InterviewService;
import com.mzk.service.InterviewinfoService;
import com.mzk.service.JobService;
import com.mzk.service.ResumeService;
import com.mzk.service.TouristService;
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
	@Autowired
	private InterviewinfoService interviewinfoService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TouristService touristService;
	
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
	
	@RequestMapping("toIntvInfo")
	public String toIntvinfo(Model model,int infoId) {
		Interviewinfo i=interviewinfoService.queryIntvinfoByInfoId(infoId);
		Resume r=resumeService.queryResumeById(i.getIntvinfoResId());
		model.addAttribute("infoResume", r);
		Job j=jobService.queryJobByName(r.getrJob());
		Employee emp=new Employee();
		emp.setEmpDepartId(j.getJobDepartId());
		emp.setEmpJobId(j.getJobId());
		emp=employeeService.queryIntvinfoEmp(emp);
		model.addAttribute("mainEmp", emp);
		return "QueryIntvInfo";	
	}
	
	@RequestMapping("sendIntvinfo")
	public String sendIntvInfoToEmp(Interviewinfo intvinfo,HttpSession session) {
		interviewinfoService.updateIntvinfoSee(intvinfo);
		List<Interviewinfo> ll=interviewinfoService.queryAllIntvinfo();
		session.setAttribute("intvinfo", ll);
		//管理员减少1个信息
		adminService.delAdminInfo();
		Admin a=(Admin) session.getAttribute("user");
		a.setaInfo(a.getaInfo()-1);
		session.setAttribute("user", a);
		Resume r=resumeService.queryResumeById(intvinfo.getIntvinfoResId());
		Tourist tor=new Tourist();
		tor.settId(r.getrTorId());
		//通知游客
		touristService.addTorInfo(tor);
		return "Admin";
	}
	
	@RequestMapping("delIntvInfo")
	@ResponseBody
	public String delIntvinfo(int infoId,HttpSession session) {
		Interviewinfo i=interviewinfoService.queryIntvinfoByInfoId(infoId);
		Tourist tor=new Tourist();
		tor.settId(i.getIntvinfoTorId());
		//把应聘信息改为未通过面试
		interviewinfoService.delIntvinfo(infoId);
		List<Interviewinfo> ll=interviewinfoService.queryAllIntvinfo();
		session.setAttribute("intvinfo", ll);
		//管理员接收信息减1
		adminService.delAdminInfo();
		Admin a=(Admin) session.getAttribute("user");
		a.setaInfo(a.getaInfo()-1);
		session.setAttribute("user", a);
		//简历状态改为未通过面试
		resumeService.updateResfail(i.getIntvinfoResId());
		//通知游客未通过面试
		touristService.addTorInfo(tor);
		return "11";
	}
}
