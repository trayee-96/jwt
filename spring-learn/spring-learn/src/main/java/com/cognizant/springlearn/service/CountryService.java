package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
@Service
public class CountryService {
	ArrayList<Country> countries=new ArrayList<>();
    public CountryService() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
    	countries = context.getBean("countryList", java.util.ArrayList.class);
    }
	public Country getCountry(String code) throws CountryNotFoundException{
		Country country=null;
		for (Country c : countries) {
			if(c.getCode().equalsIgnoreCase(code)) {
				country=c;
			}
			
		}
		if(country==null)
		throw new CountryNotFoundException();
		else 
			return country;
		
		
	}
	public Country addCountry(Country country) {
		if(countries.add(country)) {
		return country;
		}
		return null;
		
	}

}
