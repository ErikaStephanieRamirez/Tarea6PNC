<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estudiantes</title>
</head>
<body>
<center>

	<h1> Lista de todos los estudiantes</h1>
	<table>
	<thead>
			<tr>
				<th>Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Status</th>
				<th>Editar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>	
					<td><input type="button" value="Editar"
						onclick="location.href='${pageContext.request.contextPath}/update?cStudent=${students.cStudent}'" style="margin: 5px;"></td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	<form action="${pageContext.request.contextPath}/save" method="post">
	<input type="submit" value="Agregar Nuevo Estudiante">
	</form>
</center>
</body>
</html>