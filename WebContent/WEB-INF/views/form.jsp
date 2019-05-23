<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>agregar</title>
</head>
<body>
<center>
	<h3>Agregacion de estudiantes</h3>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
		
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="name" path="sName"/><br>
		<br>
		<label>Ingrese un apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		<br>	
		<label>Ingrese edad: </label>
		<form:input type="number" name="age" path="sAge"/><br>
		<br>
		<label>Estado del estudiante: </label>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		<br>
		<input type="submit" value="Agregar Estudiante">
	</form:form>
</center>
</body>
</html>