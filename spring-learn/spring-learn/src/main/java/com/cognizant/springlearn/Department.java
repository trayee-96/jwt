package com.cognizant.springlearn;

public class Department {
private String id;
private String name;
private String location;
public Department(String id, String name, String location) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
}
public Department() {
	super();
}
public String getId() {
	return id;
}
public String getName() {
	return name;
}
public String getLocation() {
	return location;
}
public void setId(String id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
}

}
