package com.pukolino.web.jdbc;

public class Employee {
	
	private int id;
	private String first_name;
	private String last_name;
	private String department;
	private int salary;
	
	
	public Employee(int id, String first_name, String last_name,
			String department, int salary) {
	
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.department = department;
		this.salary = salary;
	}
	
	public Employee(String first_name, String last_name, String department,
			int salary) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", department=" + department
				+ ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
