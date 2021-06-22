package com.assignment.pairing.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.codec.ServerCodecConfigurer;

import com.assignment.pairing.test.controller.TradeStoreController;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}

}
