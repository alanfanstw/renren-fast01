package io.renren.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String brokers;
	
	@Value("${spring.kafka.sasl.jaas.config}")
	private String saslJaasConf;
	
    public Map<String, Object> producerConfigs() {
    	 		System.setProperty("java.security.auth.login.config",saslJaasConf); // 环境变量添加，需要输入配置文件的路径
//    	  System.setProperty("java.security.auth.login.config", this.getClass().getClassLoader().getResource("kakfa-jaas.conf").toString()); // 环境变量添加，需要输入配置文件的路径
    	        Map<String, Object> props = new HashMap<>();
    	        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
    	        props.put(ProducerConfig.RETRIES_CONFIG, 0);
    	        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
    	        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
    	        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
    	        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    	        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    	        props.put("security.protocol", "SASL_SSL");
    	        props.put("sasl.mechanism", "PLAIN");
    	        return props;
    	    }
    
	@Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }

}
