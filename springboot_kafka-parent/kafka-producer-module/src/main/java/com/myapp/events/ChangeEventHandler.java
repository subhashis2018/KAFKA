package com.myapp.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import com.myapp.kafka.ChangeProducer;

public class ChangeEventHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangeEventHandler.class);

	private KafkaTemplate<String, String> KafkaTemplate;
	private String topic;

	public ChangeEventHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		super();
		KafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {

	}

	@Override
	public void onClosed() throws Exception {

	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		LOGGER.info(String.format("event data -> %s", messageEvent.getData()));
		KafkaTemplate.send(topic,messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {

	}

	@Override
	public void onError(Throwable t) {

	}

}
