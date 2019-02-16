<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h2> welcome to user view all data page</h2>

<a href="excelexport">excelexport</a>

<div class="container"></div>
<table class="table table-bordered table-striped table-hover">

<tr>

<th>userid</th>

<th>name</th>



<th>mobile-no</th>

<th>role</th>

<th colspan="3">operations</th>
</tr>

<c:forEach items="${list}" var="us">
<tr>



<td><c:out value="${us.uid}" /></td>

<td><c:out value="${us.uname}" /></td>



<td><c:out value="${us.mno}" /></td>

<td><c:out value="${us.roles}" /></td>



<td><a href="viewone?uid=${us.uid}">view one</a></td>
<td><a href="delete?uid=${us.uid}">delete</a></td>

<td><a href="showedit?uid=${us.uid}">edit</a></td>
</tr>
</c:forEach>

</table>
</div>

${deletemessage}

</body>
</html>