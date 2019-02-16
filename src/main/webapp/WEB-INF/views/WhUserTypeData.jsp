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
	<%@include file="UserMenu.jsp"%>

	<div class="container">

		<div class="card-header bg-primary text-white">

			<h2>whuserType view data page</h2>

		</div>


		<div class="card=body ">


			<a href="excelexport">excel-export</a> <br> <a href="pdfexport">pdf-export</a>


			<c:choose>

				<c:when test="${empty listall }">

					<h3>NO data found</h3>
				</c:when>

				<c:otherwise>

					<table class="table table-bordered table-hovere">

						<tr class="thead-dark">

							<th>id</th>

							<th>code</th>

							<th>email</th>

							<th>contact no</th>

							<th colspan="4">options</th>
						</tr>

						<c:forEach items="${listall}" var="wh">

							<tr>
								<td><c:out value="${wh.userId}" /></td>

								<td><c:out value="${wh.ucode}" /></td>

								<td><c:out value="${wh.email}" /></td>


								<td><c:out value="${wh.ucontact}" /></td>

								<td><a href="delete?wid=${wh.userId}"> <img
										alt="delete" src="../resources/images/delete.png" width="20"
										height="20" /></a></td>


								<td><a href="viewone?wid=${wh.userId}"> <img
										alt="delete" src="../resources/images/view.png" width="20"
										height="20" /></a></td>

								<td><a href="showedit?wid=${wh.userId}"> <img
										alt="delete" src="../resources/images/edit.png" width="20"
										height="20" /></a></td>

								<td><a href="exportone?wid=${wh.userId}"> <img
										alt="delete" src="../resources/images/excel.png" width="20"
										height="20" /></a></td>
							</tr>

						</c:forEach>

					</table>
				</c:otherwise>
			</c:choose>
		</div>

		<c:if test="${deletemessage !=null }">

			<div class="card-footer bg-danger text-white">${deletemessage}
			</div>
		</c:if>
	</div>
</body>
</html>