package org.chenhui.study.springbootstudy.controller;

import java.util.Date;

import org.chenhui.study.springbootstudy.entity.User;
import org.chenhui.study.springbootstudy.entity.result.Register;
import org.chenhui.study.springbootstudy.service.RegisterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户注册
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@RestController
public class RegisterController {
	@Autowired
	private RegisterServer registerServer;
	
	@PostMapping("/user/register")
	public Register register(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("pwd") String pwd,
			@RequestParam("email") String email,
			@RequestParam("birthday") Date birthday,
			@RequestParam("gender") char gender) {
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setEmial(email);
		user.setBirthday(birthday);
		user.setGender(gender);
		boolean b_register = registerServer.register(user,file);
		if(b_register){
			return new Register(0, "注册成功");
		}else{
			return new Register(1, "注册失败");
		}
	}
}
