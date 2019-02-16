<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
<h2>welcome to user data page</h2>

<table border="1">

<tr>

<td>userId</td>
<td> ${listone.uid} </td>

</tr>

<tr>

<td>name</td>
<td> ${listone.uname} </td>

</tr>

<tr>

<td>email</td>
<td> ${listone.email} </td>

</tr>

<tr>

<td>password</td>
<td> ${listone.pwd} </td>

</tr>

<tr>

<td>phn no</td>
<td> ${listone.mno} </td>

</tr>

<tr>

<td>Role</td>
<td> ${listone.roles} </td>

</tr>




</table>

<a href="viewall">go back</a>

</body>
</html>