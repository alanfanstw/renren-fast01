package io.renren;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class kafkaTest {
	
	
	private Gson gson = new GsonBuilder().create();
	
	@Autowired
	private KafkaTemplate<?, String> kafkaTemplate;
	
	@Test
	public void testkafka() throws Exception {
       List<String> list = new ArrayList<String>();
       list.add("testkafka");
       list.add("testcxf");
       list.add("kafkaTestaaaa");
       kafkaTemplate.send("alan.test", gson.toJson(list));
    }

}
