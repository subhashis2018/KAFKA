package com.myapp.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myapp.model.User;

@Service
public class JsonKafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics="json-topic",groupId ="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Message received -> %s", user.toString()));
		
	}

}
