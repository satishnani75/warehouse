<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">

<div class="card">

<div class="card-header bg-info text-white">
	<h2>WELCOME TO UOM REGISTER PAGE</h2>
</div>


<div class="card-body">

<form:form cssClass="form" action="save" method="post" modelAttribute="uom">

<div class="row">
	<div class="col-4">
		<label for="uomType">UOM TYPE</label>
	</div>
	<div class="col-6">
		<form:select path="uomType" cssClass="form-control">
			<form:option value="">--SELECT--</form:option>
			<form:option value="PACKING">PACKING</form:option>
			<form:option value="NO PACKING">NO PACKING</form:option>
			<form:option value="-NA-">-NA-</form:option>
		</form:select>
	</div>
</div>

<div class="row">
	<div class="col-4">
		<label for="uomModel">UOM MODEL</label>
	</div>
	<div class="col-6">
	  <form:input path="uomModel" cssClass="form-control" />
	</div>
</div>

<div class="row">
	<div class="col-4">
		<label for="uomDsc">UOM NOTE</label>
	</div>
	<div class="col-6">
	  <form:textarea path="uomDsc" cssClass="form-control" />
	</div>
</div>
<div class="row">
	<div class="col-4"></div>
	<div class="col-6">
	   <input class="btn btn-primary" type="submit" value="Register" />
	</div>
</div>
</form:form>
</div> <!-- card body close -->

<c:if test="${message != null }">
<div class="card-footer bg-success text-white">
	${message}
</div>
</c:if>

</div> <!-- card end -->
</div> <!-- container end --> 
</body>
</html>




