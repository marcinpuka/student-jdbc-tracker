<!DOCTYPE html>
<html>
<head>
	<title>Add Employee</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">
</head>

<body>
	<div id = "wrapper">
		<div id ="header">
			<h2>Frima</h2>		
		</div>
	</div>
	
		<div id ="container">
			<h3>Add Employee</h3>	
			
			<form action="EmployeeControlerServlet" method="get">
			<!-- name & value are up to you -->
			<input type="hidden" name="command" value="ADD"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" /></td> 
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" /></td> 
					</tr>
					<tr>
						<td><label>Department:</label></td>
						<td><input type="text" name="department" /></td> 
					</tr>
					<tr>
						<td><label>Salary:</label></td>
						<td><input type="text" name="salary" /></td> 
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td> 
					</tr>
				
				</tbody>
			
			
			</table>
			
			</form>	
		</div>
	
		<p>
			<a href="EmployeeControlerServlet" >Back!</a>
		</p>

</body>

</html>