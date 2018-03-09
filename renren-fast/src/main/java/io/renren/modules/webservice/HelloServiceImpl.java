package io.renren.modules.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import io.swagger.annotations.Api;

@Api("/sayHello")
@WebService(serviceName = "HelloService"//服务名
,targetNamespace = "http://localhost:8080"//报名倒叙，并且和接口定义保持一致
,endpointInterface = "io.renren.modules.webservice.HelloService")//包名
@Service("HelloService")
public class HelloServiceImpl implements HelloService {

	
	@Override
	 @GET
	 @Path("/{name}")
	 @Produces(MediaType.TEXT_PLAIN)
	 @WebMethod(action="sayHello")
	public String sayHello(@WebParam(name = "name")String name) {
		System.out.println("test-==-=-=-=-=");
		System.err.println("test-==-=-=-=-=");
        return "Hello " + name + ", Welcome to CXF RS Spring Boot World!!!";
    }

	@Override
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 @WebMethod(action="sayList")
	public String sayList(@WebParam(name = "nameList")List<String> nameList) {
		// TODO Auto-generated method stub
		return "list:"+nameList.toString();
	}

}
