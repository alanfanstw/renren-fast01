package io.renren.modules.webservice;

import java.util.List;

import javax.jws.WebService;


@WebService(targetNamespace = "http://localhost:8080")
public interface HelloService {
	
	 String sayHello(String name);  
	 String sayList(List<String> nameList);  

}
