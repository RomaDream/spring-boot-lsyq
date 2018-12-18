package org.chenhui.study.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.chenhui.study.webservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	
	@Autowired
	private UserService userService;
	
	@Bean
	public Endpoint endpoint(){
		EndpointImpl endpointImpl = new EndpointImpl(bus, userService);
		endpointImpl.publish("/HelloService");
		return endpointImpl;
	}
}
