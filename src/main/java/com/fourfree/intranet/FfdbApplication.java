package com.fourfree.intranet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fourfree")
public class FfdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FfdbApplication.class, args);
	}

}
