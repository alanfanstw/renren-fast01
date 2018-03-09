package io.renren.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import io.renren.modules.webservice.HelloService;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private HelloService helloService;
	
	@Bean
    public ServletRegistrationBean cxfServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(),"/cxf/*");  
        bean.setLoadOnStartup(0);  
        bean.setName("测试用");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }    
    
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),helloService);
//        endpoint.setServiceName);
//        endpoint.setWsdlLocation(weatherClient().getWSDLDocumentLocation().toString());
        endpoint.publish("/services");
//        endpoint.setAddress("http://localhost:8080"+cxfServlet().getServletName());
//        endpoint.setWsdlLocation("hello1.0.wsdl");
        return endpoint;
    }
    
    @Bean
    public SpringBus weatherClient() {
        return new SpringBus();
    }
}
