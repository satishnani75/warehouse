<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%@include file="UserMenu.jsp" %>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">


				<h2>well come to shipment type update page</h2>


			</div>


			<div class="card-body ">



				<form:form action="update" method="post"
					modelAttribute="shipmentType">



					<div class="row">


						<div class="col-4">

							<label for="id">shipment id </label>
						</div>

						<div class="col-6">

							<form:input path="id" readonly="true" cssClass="form-control" />


						</div>
					</div>

					<div class="row">


						<div class="col-4">

							<label for="shipmentMode"> shipment mode </label>
						</div>

						<div class="col-6">

							<form:select path="shipmentMode" cssClass="form-control">

								<form:option value="">--select--</form:option>
								<form:option value="AIR">Air</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>



							</form:select>

						</div>

					</div>



					<div class="row">


						<div class="col-4">

							<label for="shipmentCode">shipment Code</label>
						</div>

						<div class="col-6">
							<form:input path="shipmentCode" cssClass="form-control" />

						</div>
					</div>

					<div class="row">


						<div class="col-4">

							<label for="enableShipment">Enable shipment</label>
						</div>

						<div class="col-6">

							<form:select path="enableShipment" cssClass="form-control">

								<form:option value=" ">--select--</form:option>

								<form:option value="YES">yes</form:option>
								<form:option value="NO">no</form:option>

							</form:select>
						</div>


					</div>

					<div class="row">

						<div class="col-4">
							<label for="shipmentGrade">shipment grade</label>

						</div>

						<div class="col-6">

							<form:radiobutton path="shipmentGrade" value="A" />
							A
							<form:radiobutton path="shipmentGrade" value="B" />
							B
							<form:radiobutton path="shipmentGrade" value="C" />
							C
						</div>
					</div>

					<div class="row">

						<div class="col-4">

							<label for="shipdesc">description</label>
						</div>

						<div class="col-6">

							<form:textarea path="shipdesc" cssClass="form-control" />
						</div>

					</div>

					<div class="row">

						<div class="col-4">

							<a href="all">view all</a>
						</div>

						<div class="col-6">

							<input class="btn btn-primary" type="submit"
								value=" createshipment">

						</div>

					</div>
				</form:form>

			</div>


			<c:if test="${message != null }">

				<div class="card-footer bg-success">${message}</div>

			</c:if>



		</div>
	</div>

	



</body>
</html>