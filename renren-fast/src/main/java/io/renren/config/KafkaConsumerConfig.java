package io.renren.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
    private String brokers;

    @Value("${spring.kafka.consumer.group-id}")
    private String group;
    
	@Value("${spring.kafka.sasl.jaas.config}")
	private String saslJaasConf;
    
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(4);
        factory.getContainerProperties().setPollTimeout(4000);
        return factory;
    }

    @Bean
    public KafkaListeners kafkaListeners() {
        return new KafkaListeners();
    }
    
//    public KafkaConsumerConfig() {
//    	System.out.println("KafkaConsumerConfig.class.getClassLoader()"+KafkaConsumerConfig.class.getClassLoader());
//		URL authLocation = KafkaConsumerConfig.class.getClassLoader().getResource("kafka_jaas.conf");
//		if (System.getProperty("java.security.auth.login.config") == null) {
//			System.setProperty("java.security.auth.login.config", authLocation.toExternalForm());
//		}
//	}
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
    }

    
    public Map<String, Object> consumerConfigs() {
	    System.setProperty("java.security.auth.login.config",saslJaasConf); // 环境变量添加，需要输入配置文件的路径
//        System.setProperty("java.security.auth.login.config", this.getClass().getClassLoader().getResource("kafka-jaas.conf").toString()); // 环境变量添加，需要输入配置文件的路径
         
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        propsMap.put("security.protocol","SASL_SSL");
        propsMap.put("sasl.mechanism", "PLAIN");
        return propsMap;
    }
}
