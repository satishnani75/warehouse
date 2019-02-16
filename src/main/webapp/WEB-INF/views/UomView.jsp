<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
<h2> welcome to uomview page </h2>

<table border="1">
<tr>

<td>uid</td>
<td>${uall.uomId} </td>
</tr>
<tr>
<td>utype</td>

<td> ${uall.uomType}</td>

</tr>

<tr>
<td>umodel</td>
<td>${uall.uomModel}</td>

</tr>

<tr>
<td>udesc</td>
<td>${uall.dsc}</td>

</tr>
</table>

<a href="uall">go back</a>

</body>
</html>