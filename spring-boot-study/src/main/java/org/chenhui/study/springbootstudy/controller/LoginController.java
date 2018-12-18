package org.chenhui.study.springbootstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chenhui.study.springbootstudy.entity.User;
import org.chenhui.study.springbootstudy.entity.result.LoginFail;
import org.chenhui.study.springbootstudy.entity.result.LoginSuccess;
import org.chenhui.study.springbootstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private HttpServletRequest request;
	@ModelAttribute
	private void init(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
	}
	
	@PostMapping("/user/login")
	public Object login(@RequestParam("username") String username,
			            @RequestParam("password") String password){
		
		User user = userService.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("loginuser", user);
			LoginSuccess loginSuccess = new LoginSuccess(0, "登陆成功");
			return loginSuccess;
		}else{
			LoginFail loginFail = new LoginFail(1, "登录失败");
			return loginFail;
		}
	}
}
