package com.bravo.bakery;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakeryApplication {

	Logger log = Logger.getLogger(BakeryApplication.class);

	@PostConstruct
	private void toGreet() {
		log.info("Welcome to Bakery");
	}

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}

}
