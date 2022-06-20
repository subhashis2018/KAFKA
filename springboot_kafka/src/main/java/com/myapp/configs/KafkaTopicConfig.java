package com.myapp.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic topics() {
		return TopicBuilder.name("string-topic").build();
	}
	
	@Bean
	public NewTopic jsonTopics() {
		return TopicBuilder.name("json-topic").build();
	}
}
