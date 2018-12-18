package org.chenhui.study.springbootwebservices;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebservicesApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		JaxWsDynamicClientFactory clientFactroy = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactroy.createClient("http://127.0.0.1:8080/services/HelloService?wsdl");
		Object[] invoke = client.invoke("sayHi");
		System.out.println(invoke[0].toString());
	}

}

