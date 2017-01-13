package com.pukolino.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDButil {

	private DataSource dataSource;

	public EmployeeDButil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employee> getEmployees() throws Exception {

		List<Employee> employees = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from employees order by last_name";

			myStmt = myConn.createStatement();

			// execute querry
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String first_name = myRs.getString("first_name");
				String last_name = myRs.getString("last_name");
				String department = myRs.getString("department");
				int salary = myRs.getInt("salary");

				// create new student object
				Employee tempEmployee = new Employee(id, first_name, last_name,
						department, salary);

				// add it to the list of students
				employees.add(tempEmployee);
			}
			
			return employees;
		} finally {
				// close JDBC object	
				close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt!= null) {
				myStmt.close();
			}
			if (myConn!=null){
				myConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void add(Employee theEmployee) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection 
			myConn = dataSource.getConnection();
			
			// create sql for insert 
			String sql = "insert into employees " 
					+ "(first_name, last_name, department, salary) "
					+ "values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			// set the param value for the Employee
			
			myStmt.setString(1, theEmployee.getFirst_name());
			myStmt.setString(2, theEmployee.getLast_name());
			myStmt.setString(3, theEmployee.getDepartment());
			int sal = theEmployee.getSalary();
			String salary = Integer.toString(sal);
			myStmt.setString(4, salary);
			
			// execute the query
			myStmt.execute();
			
		} finally {
			close(myConn, myStmt, null);
		}
		 
		
	}

}
