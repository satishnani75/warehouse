<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>

	<h2>uom reg edit form</h2>


	<!-- spring tag from  -->

	<form:form action="umupdate" method="post" modelAttribute="uom">

		<pre>
		
		uom id : <form:input path="uomId" readonly="true"/>

      uom type : <form:select path="uomType">


                  <form:option value=" ">--select---</form:option>
                  
                  <form:option value="PACKAGE">package</form:option>
                  
                  
                  <form:option value="NO PACKAGE ">no package</form:option>
                  
                  <form:option value="NA">NA</form:option>
                  
                  </form:select>
                  
                  
uom model   :<form:input path="uomModel" />

description : <form:textarea path="dsc" />

<input type="submit" value="update Uom">






</pre>



	</form:form>


	${message}
	<br>


	<a href="uall">showall</a>


</body>
</html>