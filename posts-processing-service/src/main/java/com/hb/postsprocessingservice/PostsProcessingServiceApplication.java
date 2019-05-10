package com.hb.postsprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.client.RestTemplate;

@EnableJms
@SpringBootApplication
public class PostsProcessingServiceApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(PostsProcessingServiceApplication.class, args);
	}

}
