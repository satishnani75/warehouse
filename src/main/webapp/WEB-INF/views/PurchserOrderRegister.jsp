<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

			<div class="card-header">

				<h4>welcome to purchase order page</h4>
			</div>


			<div class="card-body">

				<form:form action="save" method="post"
					modelAttribute="purchaseOrder">

					<div class="row">

						<div class="col-4">order-code:</div>

						<div class="col-6">

							<form:input path="orderCode" cssClass="form-control" />

							<p>
								<form:errors path="orderCode" cssClass="error"></form:errors>
						</div>
					</div>




					<div class="row">

						<div class="col-4">shipment code :</div>

						<div class="col-6">

							<form:select path="ship.id" cssClass="form-control">

								<form:option value="">--select--</form:option>

								<form:options items="${shipment}" itemLabel="shipmentCode"
									itemValue="id"/>

							</form:select>
                   <%--  <form:errors path="shipmentCode" cssClass="error"/> --%>
								
						</div>
					</div>

					<div class="row">

						<div class="col-4">vendor :</div>

						<div class="col-6">



							<form:select path="vendor.userId" cssClass="form-control">


								<form:option value="">--select---</form:option>
								
								<form:options items="${whusr}" itemLabel="ucode" itemValue="userId"/>

							</form:select>

								<form:errors path="vendor" cssClass="error"></form:errors>
						</div>
					</div>

					<div class="row">

						<div class="col-4">refrence Number :</div>

						<div class="col-6">

							<form:input path="refno" cssClass="form-control" />

						<form:errors path="refno" cssClass="error"></form:errors>
						</div>
					</div>


					<div class="row">

						<div class="col-4">quality check :</div>

						<div class="col-6" cssClass="form-control">

							<form:radiobutton path="qc" value="Requried" />
							Required

							<form:radiobutton path="qc" value="notRequried" />
							notRequired

							<p>
								<form:errors path="qc" cssClass="error"></form:errors>
						</div>
					</div>



					<div class="row">

						<div class="col-4">default Status</div>

						<div class="col-6">

							<form:input path="orderstatus" cssClass="form-control" />


								<form:errors path="orderstatus" cssClass="error"></form:errors>
						</div>
					</div>


					<div class="row">

						<div class="col-4">description</div>

						<div class="col-6">

							<form:textarea path="orderdesc" cssClass="form-control" />


								<form:errors path="orderdesc" cssClass="error"></form:errors>
						</div>
					</div>



					<div class="row">

						<div class="col-4"></div>

						<div class="col-6">

							<input type="submit" value="submit">

						</div>
					</div>

					<c:if test="${savemessage != null}">

						<div class="card-footer bg-success">${savemessage}</div>

					</c:if>





				</form:form>

			</div>
			<!--  body -->

		</div>


	</div>
	<!--  container -->

</body>
</html>