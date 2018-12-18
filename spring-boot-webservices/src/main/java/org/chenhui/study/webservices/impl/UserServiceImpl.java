package org.chenhui.study.webservices.impl;

import javax.jws.WebService;

import org.chenhui.study.webservices.UserService;
import org.springframework.stereotype.Component;

@WebService(serviceName = "helloWebService", //web服务名称
		endpointInterface = "org.chenhui.study.webservices.UserService",//接口全包名
		targetNamespace = "http://webservices.study.chenhui.org")
@Component
public class UserServiceImpl implements UserService{

	@Override
	public String sayHi() {
		System.out.println("say Hi!");
		return "hello world,spring-boot-ws";
	}
	
}
