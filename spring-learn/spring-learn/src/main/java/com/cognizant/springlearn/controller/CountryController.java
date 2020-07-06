package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
//@RequestMapping(path = "/country")
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Hellocontroller.class);
	ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
	Validator validator=factory.getValidator();
    @Autowired
	private CountryService countryService;
    
	/* 03-02 spring-REST handson- Country Web Service */
	@GetMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("Start");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Country.xml");
		Country ctr=ctx.getBean("country",Country.class);
		LOGGER.debug("Country: {}",ctr);
		LOGGER.info("end");
		return ctr;
	}

	/* 03-02 spring-REST handson - Get all countries */
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Country.xml");
		ArrayList<Country> ctrl=ctx.getBean("countryList",ArrayList.class);
		LOGGER.debug("Country: {}",ctrl);
		LOGGER.info("end");
		return ctrl;
		
	}

	/* 03-02 spring-REST - Get country based on country code */
	@GetMapping("/countries/{code}") 
	public Country getCountry(@PathVariable String code)throws CountryNotFoundException {
		return countryService.getCountry(code);
	}
	@PostMapping("/countries") 
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Start");
		LOGGER.info("end");
		/*Set<ConstraintViolation<Country>> violations=validator.validate(country);
	List<String> errors=new ArrayList<String>();
	for(ConstraintViolation<Country> violation:violations) {
		errors.add(violation.getMessage());
	}
	if(violations.size()>0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
	}*/
		return countryService.addCountry(country);
		
	}
}
