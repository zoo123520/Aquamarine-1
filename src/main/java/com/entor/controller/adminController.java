package com.entor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {
	@RequestMapping("/admin")
	public String admin() {
		
		return "admin/home";
	}
	@RequestMapping("/userPayRecord")
	public String userPayRecord() {
		
		return "admin/userPayRecord";
	}
	@RequestMapping("/userRecharge")
	public String userRecharge() {
		
		return "admin/userRecharge";
	}
	@RequestMapping("/userTeach")
	public String userTeach() {
		
		return "admin/userTeach";
	}
	@RequestMapping("/userManage")
	public String userManage() {
		
		return "manage/userManage";
	}
}
