package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Hellocontroller.class);
	@GetMapping("/hello")
	
	/* 03-02 spring Hello World RESTful Web Service Handson */
	public String sayHello() {
		LOGGER.info("Start");
		return "Hello World!!" ;
	}
}
