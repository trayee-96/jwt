package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		displayCountries();
	}
	
	/* 03-01 Spring-rest Handson 2 & 3 */

	public static void displayDate() throws ParseException {
		LOGGER.info("start");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("dateformat.xml");
		SimpleDateFormat fr=ctx.getBean("dateFormat",SimpleDateFormat.class);
		Date d=fr.parse("31/12/2018");
		String date=d.toString();
		LOGGER.debug("Date: {}",date);
		//System.out.println(date);
		LOGGER.info("End");
		
	}
	/* 03-01 Spring-rest Handson 4 */
	public static void displayCountry() {
		LOGGER.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		Country country = (Country) context.getBean("country", Country.class); 
		LOGGER.debug("Country : {}", country.toString()); 
		LOGGER.info("End");

	}
	/* 03-01 Spring-rest  Handson 6 */
	public static void displayCountries() {
		LOGGER.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country : {}", countryList.toString()); 
		LOGGER.info("End");

	}
}
