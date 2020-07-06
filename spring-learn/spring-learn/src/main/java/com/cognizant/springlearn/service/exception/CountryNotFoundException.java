package com.cognizant.springlearn.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Countrynotfound") 
public class CountryNotFoundException extends Exception{

}
