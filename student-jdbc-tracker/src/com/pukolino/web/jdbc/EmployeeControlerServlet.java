package com.pukolino.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControlerServlet
 */
@WebServlet("/EmployeeControlerServlet")
public class EmployeeControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDButil employeeDButil;
	
	@Resource(name="jdbc/demo")
	private DataSource dataSource;
	
	
	

	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our employee db util ... and pass in the conn pool/datasource
		try {
			employeeDButil = new EmployeeDButil (dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);			
		}
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// list the employee in mvc fashion 
		try {
			
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listin students
			if (theCommand == null) {
				theCommand="LIST";
			}
			
			// route to the appropriate method
			switch (theCommand){
			
			case "LIST":
				listEmployees(request,response);
				break;
			case "ADD":
				addEmployee(request, response);
				break;
			default:
				listEmployees(request,response);
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// read employee info from form data
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String department=request.getParameter("department");
		String salaryString =request.getParameter("salary");
		int salary = Integer.parseInt(salaryString);
		
		//  create a new employee object
		Employee theEmployee = new Employee(firstName, lastName, department, salary);
		
		// add the employee to the database 
		employeeDButil.add(theEmployee);
		
		// send back to main page (the employees list) 
		listEmployees(request, response);
	}




	private void listEmployees(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// get emp from db util 
		List<Employee> employees = employeeDButil.getEmployees();
		
		// add emp to the request 
		request.setAttribute("EMPLOYEE_LIST", employees);
		
		// send to jsp page 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
		dispatcher.forward(request, response);
		
	}

}
