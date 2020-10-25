package com.quguai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 默认支持两种技术
 * 1. Jest
 * 2. SpringData ElasticSearch
 */
@SpringBootApplication
public class Springboot14ElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot14ElasticsearchApplication.class, args);
	}

}
