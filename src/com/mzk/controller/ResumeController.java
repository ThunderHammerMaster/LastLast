package com.mzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mzk.service.ResumeService;
@RequestMapping("/resume")
@Controller
public class ResumeController {
	@Autowired
	private ResumeService resumeService;
	
}
