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




	<!-- <form action="uomreg" method="post">

<pre>
Uom type : <select name="uomType">


         <option value=" ">--select--</option>

         <option value="PACKAGE">package</option>
         
         <option value="NO PACKAGE">no package</option>
         
         
         <option value="NA">--NA--</option>
              </select>

uom Model :<input type="text" name="uomModel">

description :<textarea name="dsc"></textarea>


<input type="submit"      value="register uom"> 


</pre>
</form> -->

	<!-- spring tag from  -->

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white text-center">

				<h2>uom registration form</h2>

			</div>
			<div class="card-body">

				<form:form cssClass="form" action="uomreg" method="post"
					modelAttribute="uom">



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

							<input class="btn btn-primary" type="submit" value="create Uom">

						</div>
					</div>




				</form:form>

				<c:if test="${msg !=null }">

					<div class="card-footer bg-success text-white">

						${msg} <br>

					</div>

				</c:if>


				<a href="uall">showall</a>



			</div>
			<!--  cord footer end -->
		</div>
		<!-- card end -->
</body>
</html>