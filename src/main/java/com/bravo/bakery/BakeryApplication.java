package com.bravo.bakery;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bravo.bakery.config.AppConf;

@SpringBootApplication
public class BakeryApplication {

	@Autowired
	AppConf appConf;

	Logger log = Logger.getLogger(BakeryApplication.class);

	@PostConstruct
	private void toGreet() {
		String appName = appConf.getConfigValue("spring.application.name");
		log.info("Hi, I'm " + appName);
	}

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}

}
