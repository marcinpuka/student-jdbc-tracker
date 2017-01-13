 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<title>Employees App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
<div id="wrapper">
	<div id="header">
		<h2> Firma </h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
		<!-- Button Add Employee -->
		<input type="button" value="Add Employee"
				onclick="window.location.href='add-employee-form.jsp'; return false;"
					class="add-employee-button"
		/>
		<table>
			<tr>
				<!-- Table colums' names -->
				<th> First Name </th>
				<th> Last Name </th>
				<th> Department </th>
				<th> Salaray </th>
				<th> Action </th>
				
			</tr>
			
			<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
			
			<tr>
				<!--  JSTL Link for each employee  -->
				<c:url var="tempLink" value="EmployeeControlServlet">
					<c:param name = "command" value="LOAD" />
					<c:param name = "employeId" value="${tempEmployee.id}" />
				</c:url>
				
				<td>  ${tempEmployee.first_name} </td>
				<td>  ${tempEmployee.last_name}</td>
				<td>  ${tempEmployee.department} </td>
				<td>  ${tempEmployee.salary} </td>
				<td>  <a href="${tempLink}">Update</a>  </td>
				
			</tr>
			
			</c:forEach>
		
		</table>
	</div>
</div>
	

</body>
</html>





