package org.chenhui.study.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "helloWebService", //暴露服务名称
		targetNamespace = "http://webservices.study.chenhui.org"  //命名空间，一般是包名的倒序
		)
public interface UserService {
	
	//暴露在webservice接口服务上的方法
	@WebMethod
	public String sayHi();
}
