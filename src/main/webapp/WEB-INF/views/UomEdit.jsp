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


	<%@include file="UserMenu.jsp"%>



	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white text-center">

				<h2 align="center">uom reg Edit form</h2>

			</div>
			<div class="card-body">



				<form:form cssClass="form" action="umupdate" method="post"
					modelAttribute="uom">


					<div class="row">

						<div class="col-4">
							<label for="uomId"> uom Id</label>
						</div>

						<div class="col-6">

							<form:input path="uomId" readonly="true" />

						</div>
					</div>


					<div class="row">

						<div class="col-4">

							<label for="uomType">uom type :</label>

						</div>

						<div class="col-6">
							<form:select path="uomType" cssClass="form-control">


								<form:option value=" ">--select---</form:option>

								<form:option value="PACKAGE">package</form:option>


								<form:option value="NO PACKAGE ">no package</form:option>

								<form:option value="NA">NA</form:option>

							</form:select>
						</div>

					</div>


					<div class="row">

						<div class="col-4">
							<label for="uomModel"> uom model :</label>
						</div>

						<div class="col-6">
							<form:input path="uomModel" cssClass="form-control" />

							<form:errors path="uomModel" cssClass="error"></form:errors>
						</div>

					</div>


					<div class="row">

						<div class="col-4">
							<label for="dsc"> description</label>
						</div>

						<div class="col-6">

							<form:textarea path="dsc" cssClass="form-control" />

						</div>
					</div>




					<div class="row">

						<div class="col-4"></div>



						<div class="col-6">

							<input class="btn btn-primary" type="submit" value="update uom">

						</div>
					</div>




				</form:form>

				<c:if test="${message !=null }">

					<div class="card-footer bg-success text-white">

						${message} <br>

					</div>

				</c:if>


				<a href="uall">showall</a>



			</div>
			<!--  cord footer end -->
		</div>
		<!-- card end -->
</body>
</html>