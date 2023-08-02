package com.example.creative_works_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CreativeWorksChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreativeWorksChallengeApplication.class, args);
	}

}
