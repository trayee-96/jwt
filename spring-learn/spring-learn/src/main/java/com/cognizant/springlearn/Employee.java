package com.cognizant.springlearn;

public class Employee {
	private String id;
	private String name;
	private String salary;
	private Department department;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee(String id, String name, String salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}


}
