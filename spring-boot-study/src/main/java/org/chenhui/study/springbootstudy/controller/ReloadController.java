package org.chenhui.study.springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试热部署是否生效控制器
 * 
 * @author  chenhui
 * @time    2018年12月21日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@RestController
public class ReloadController {
	
	@GetMapping("/reload")
	public String reload(){
		return "change code reload";
	}
}
