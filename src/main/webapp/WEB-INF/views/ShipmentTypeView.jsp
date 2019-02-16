<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Shipement type view-one page</h2>

	<table border="1">
		<tr>
			<td>id</td>

			<td>${vone.id}</td>

		</tr>


		<tr>
			<td>mode</td>

			<td>${vone.shipmentMode}</td>

		</tr>


		<tr>
			<td>code</td>

			<td>${vone.shipmentCode}</td>

		</tr>

		<tr>
			<td>enable</td>

			<td>${vone.enableShipment}</td>

		</tr>

		<tr>
			<td>grade</td>

			<td>${vone.shipmentGrade}</td>

		</tr>


		<tr>
			<td>sdsc</td>

			<td>${vone.shipdesc}</td>

		</tr>




	</table>


<a href="all">goback</a>

</body>
</html>