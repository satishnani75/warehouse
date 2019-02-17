<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>

<%@include file="UserMenu.jsp" %>

	<h2>Order method update form</h2>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white ">

				<h3>Order method edit form</h3>

			</div>

			<div class="card-body">




				<form:form action="omupdate" method="post"
					modelAttribute="orderMethod">



<div class="row">

						<div class="col-4">
							<label for="oid">order Id </label>
						</div>

						<div class="col-6">

							<form:input path="oid" readonly="true" />

							<p style="color: red;">
								<form:errors path="oid" cssClass="error" />
							</p>
						</div>

					</div>

					<div class="row">

						<div class="col-4">

							<label for="orderMode">order mode</label>
						</div>

						<div class="col-6">

							<form:radiobutton path="orderMode" value="Sale" />
							sale

							<form:radiobutton path="orderMode" value="purchase" />
							purchase <br>

							<p style="color: red;">
								<form:errors path="orderMode" cssClass="error"></form:errors>
							</p>
						</div>

					</div>

					<div class="row">

						<div class="col-4">

							<label for="orderCode">order-code</label>
						</div>

						<div class="col-6">

							<form:input path="orderCode" cssClass="form-control" />

							<p style="color: red;">
								<form:errors path="orderCode" cssClass="error"></form:errors>
							</p>
						</div>

					</div>

					<div class="row">

						<div class="col-4">
							<label for="exeType">exicute type :</label>

						</div>

						<div class="col-6">

							<form:select path="exeType" cssClass="form-control">

								<form:option value="">--select--</form:option>

								<form:option value="FIFO">FIFO</form:option>

								<form:option value="LIFO">LIFO</form:option>

								<form:option value="FCFO">FCFO</form:option>

								<form:option value="FEFO">FEFO</form:option>



							</form:select>

							<p style="color: red;">
								<form:errors path="exeType" cssClass="error" />
							</p>

						</div>



					</div>

					<div class="row">

						<div class="col-4">

							<label for="orderAccept">order accept</label>
						</div>

						<div class="col-6">

							<form:checkbox path="orderAccept" value="mutltimode" />
							multi-mode
							<form:checkbox path="orderAccept" value="accept return " />
							accept return
							<form:checkbox path="orderAccept" value="service extend" />
							service extend

							<p style="color: red;">
								<form:errors path="orderAccept" cssClass="error" />
							</p>
						</div>

					</div>

					<div class="row">

						<div class="col-4">
							<label>description :</label>
						</div>

						<div class="col-6">

							<form:textarea path="orderDesc" cssClass="form-control" />

							<p style="color: red;">
								<form:errors path="orderDesc" cssClass="error" />
							</p>
						</div>

					</div>

					<div class="row">

						<div class="col-4">

							<a href="omviewall"> view all</a>
						</div>

						<div class="col-6">

							<input class="btn btn-success" type="submit"
								value="create ordermethod">

						</div>


					</div>

				</form:form>

			</div>
			<!--  body  -->

			<c:if test="${message!=null }">

				<div class="card-footer bg-primary">
					<h4>${message}</h4>

				</div>

			</c:if>




			
			



			

		</div>
	</div>


</body>

</html>