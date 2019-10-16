package com.entor.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entor.entity.User;
import com.entor.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		return "redirect:/login";
	}
	@RequestMapping("/index")
	public String index(Map<String,Object> map) {
		/*Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		
		map.put("username", user.getUsername());*/
		
		return "fore/index";
	}
	@RequestMapping("/login")
	public String login() {
		return "fore/login";
	}
	@RequestMapping("/loginCheck")
	public String loginCheck(@RequestParam(defaultValue="hello")String username ,@RequestParam(defaultValue="world")String password,Map<String, Object>map) {
		System.out.println("明文密码"+password);
		SimpleHash hash = new SimpleHash("md5", password, "qwer",10);
		String enpassword = hash.toHex();
		System.out.println("经过md5密文为“qwer”加密10次盐的密码:"+enpassword);
		UsernamePasswordToken token = new UsernamePasswordToken(username, enpassword);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "forward:/admin";
		}catch(Exception e) {
			map.put("msg", "账号或者密码错误");
			map.put("user", token);
			return "forward:/login";
		}
	}
}
