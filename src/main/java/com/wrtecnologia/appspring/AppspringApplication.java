package com.wrtecnologia.appspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppspringApplication.class, args);
	}

}
