package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.Employeedao;

@Service
public class EmployeeService {
	@Autowired
	private Employeedao dao;
private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	public EmployeeService() {
		LOGGER.debug("Employee Rest Service Called!");
	}
 
    public ArrayList<Employee> getAllEmployees() {
	return dao.getAllEmployees();
}
}
