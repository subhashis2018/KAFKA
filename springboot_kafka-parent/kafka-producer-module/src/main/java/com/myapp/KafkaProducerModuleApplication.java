package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapp.kafka.ChangeProducer;

@SpringBootApplication
public class KafkaProducerModuleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerModuleApplication.class, args);
	}

	@Autowired
	private ChangeProducer changeProducer;

	@Override
	public void run(String... args) throws Exception {
		changeProducer.sendMessage();
	}

}
