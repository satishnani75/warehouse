<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
<div class="container">

<div class="card">


	<div class="card-header bg-primary text-white">
		 <h2>WELCOME TO UOM DATA PAGE</h2>
	</div> <!-- card header end -->


	

	<div class="card-body">
	
	<c:choose>
		<c:when test="${empty uoms }">
			<h4>No Data Found</h4>
		</c:when>
		<c:otherwise>
	<table class="table table-bordered table-hover">
		<tr class="thead-dark">
			<th>ID</th>
			<th>TYPE</th>
			<th>MODEL</th>
			<th>NOTE</th>
			<th>OPERATIONS</th>
		</tr>
		<c:forEach items="${uoms}" var="uom">
			<tr>
			<%-- <c:if test="${uom.id ==1}">
				<tr class="table-primary">
			</c:if>
			<c:if test="${uom.id !=1}">
				<tr>
			</c:if> --%>
				<td><c:out value="${uom.id}" /></td>
				<td><c:out value="${uom.uomType}" /></td>
				<td><c:out value="${uom.uomModel}" /></td>
				<td><c:out value="${uom.uomDsc}" /></td>
				<td><a href="delete?id=${uom.id}">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
		</c:otherwise>
	
	</c:choose>
	</div> <!-- card body class end -->
	
	<c:if test="${message != null}">
	<div class="card-footer bg-danger text-white">
		${message}
	</div>
	</c:if>
	
	
	</div> <!-- card class end -->
</div> <!--  container class end -->
</body>
</html>



