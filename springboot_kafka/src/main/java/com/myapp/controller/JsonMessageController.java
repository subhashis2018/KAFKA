package com.myapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.kafka.JsonKafkaProducer;
import com.myapp.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	    // URL: localhost:9000/api/v1/kafka/publish
		@PostMapping("/publish")
		public ResponseEntity<String> publish(@RequestBody User user) {
			jsonKafkaProducer.sendMessage(user);
			return ResponseEntity.ok("Json message sent to kafka topic");
		}


}
