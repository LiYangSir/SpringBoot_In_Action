package com.quguai;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringBoot13RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot13RabbitmqApplication.class, args);
	}

}
