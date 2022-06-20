package com.myapp.kafka;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.myapp.events.ChangeEventHandler;

@Service
public class ChangeProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangeProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public ChangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() throws InterruptedException{
		LOGGER.info(String.format("From ChangeProducer sendMessage()"));
		String topic = "ms-topic";
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		
		//To read real time stream data we use event source
		EventHandler eventHandler=new ChangeEventHandler(kafkaTemplate, topic);
		EventSource eventSource=new EventSource.Builder(eventHandler, URI.create(url)).build();
		eventSource.start();
		TimeUnit.MINUTES.sleep(5);
		
	}
}
