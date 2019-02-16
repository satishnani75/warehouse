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

	<h2>order method   view-one page</h2>

	<table border="1">
		<tr>
			<td>id</td>

			<td>${omviewone.oid}</td>

		</tr>


		<tr>
			<td>mode</td>

			<td>${omviewone.orderMode}</td>

		</tr>


		<tr>
			<td>code</td>

			<td>${omviewone.orderCode}</td>

		</tr>

		<tr>
			<td>exetype</td>

			<td>${omviewone.exeType}</td>

		</tr>

		<tr>
			<td>desc</td>

			<td>${omviewone.orderDesc}</td>

		</tr>


		<tr>
			<td>accept</td>

			<td>${omviewone.orderAccept}</td>

		</tr>




	</table>


<a href="omviewall">goback</a>

</body>
</html>