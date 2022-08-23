package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
@ComponentScan("com.demo")
public class ApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaApplication.class, args);
	}
	
	@KafkaListener(topics="GENERAL",groupId="group-id")
	public void listen(String message) {
		System.out.println("Message  received: "+message);
	}

}