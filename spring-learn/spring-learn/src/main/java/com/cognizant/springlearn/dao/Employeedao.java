package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
@Repository
public class Employeedao {
	private static ArrayList<Employee> EMPLOYEE_LIST;
	Employeedao(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("employee.xml") ;
		EMPLOYEE_LIST=ctx.getBean("employeeList",ArrayList.class);
	}
	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
}
