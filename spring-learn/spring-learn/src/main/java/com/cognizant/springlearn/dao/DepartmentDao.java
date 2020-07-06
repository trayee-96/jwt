package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Department;

@Repository
public class DepartmentDao {
	private static ArrayList<Department> DEPARTMENT_LIST;

	public DepartmentDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = ctx.getBean("deptList", ArrayList.class);
	}

	public ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
