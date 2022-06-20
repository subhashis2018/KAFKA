package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@SpringBootApplication
public class SpringbootKafkaParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaParentApplication.class, args);
	}

}
