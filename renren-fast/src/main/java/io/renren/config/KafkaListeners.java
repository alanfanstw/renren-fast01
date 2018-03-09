package io.renren.config;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListeners {

//	private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"alan.test"})
    public void processMessage(String content) {
        
        System.out.println(content.toString());
    }
}
