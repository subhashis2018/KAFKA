package com.myapp.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.myapp.model.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {
		LOGGER.info(String.format("Message produced ->  %s", data.toString()));
		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "json-topic").build();
		kafkaTemplate.send(message);
	}

}
