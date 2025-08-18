package com.quorum.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuorumApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuorumApplication.class, args);
		System.out.println("Quorum Application");

	}

}
