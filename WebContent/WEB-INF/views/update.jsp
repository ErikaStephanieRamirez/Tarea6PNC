<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar</title>
</head>
<body>
<center>

	<h3>Editar de estudiantes</h3>
	<form:form action="${pageContext.request.contextPath}/guardar" modelAttribute="student">
	
	    <form:input type="hidden" name="id" path="CStudent"/>
		
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="sName" path="sName"/><br>
		<br>
		<label>Ingrese un apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		<br>
		<label>Ingrese edad: </label>
		<form:input type="number" name="sAge" path="sAge"/><br>
		<br>
		<label>Estado del estudiante:</label>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		<br>
		<input type="submit" value="Modificar estudiante">
	</form:form>
	<br>
	<input type="button" value="Eliminar"
						onclick="location.href='${pageContext.request.contextPath}/delete?cStudent=${student.cStudent}'">
	
</center>
</body>
</html>