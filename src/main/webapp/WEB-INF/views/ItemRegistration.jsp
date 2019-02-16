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


			<div class="card-header bg-success text-white">

				<h4>welcome to items page</h4>
			</div>
			<!--header   -->

			<div class="card-body ">


				<form:form action="saveitem" method="post" modelAttribute="item">

					<div class="row">

						<div class="col-4">Item code :</div>
						<div class="col-6">

							<form:input path="itemcode" cssClass="form-control" />

							<p style="color: red;">
								<form:errors path="itemcode" cssClass="error" />
							</p>

						</div>

					</div>

					<div class="row">

						<div class="col-4">Item dimentions :</div>

						<div class="col-2 text-primary">
							Width
							<form:input path="width" cssClass="form-control" />


							<p style="color: red;">
								<form:errors path="width" />
							</p>

						</div>

						<div class="col-2 text-primary">
							Length
							<form:input path="length" cssClass="form-control" />


							<p style="color: red;">
								<form:errors path="length" cssClass="error" />
							</p>

						</div>


						<div class="col-2 text-primary">
							Height
							<form:input path="height" cssClass="form-control" />

							<p style="color: red;">
								<form:errors path="height" cssClass="error" />
							</p>

						</div>

					</div>

					<div class="row">

						<div class="col-4">Base cost</div>
						<div class="col-6">

							<form:input path="cost" cssClass="form-control" />



							<p style="color: red;">
								<form:errors path="cost" cssClass="error" />
							</p>

						</div>

					</div>


					<div class="row">

						<div class="col-4">Base currency</div>
						<div class="col-6">

							<form:select path="baseCurrency" cssClass="form-control">

								<form:option value="">--select---</form:option>

								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>


							</form:select>

							<p style="color: red;">
								<form:errors path="baseCurrency" cssClass="error" />
							</p>

						</div>

					</div>

					<div class="row">

						<div class="col-4">description :</div>
						<div class="col-6">

							<form:textarea path="descrep" cssClass="form-control" />

							<p style="color: red;">
								<form:errors path="descrep" cssClass="error" />
							</p>

						</div>

					</div>

					<%-- 
					
					// by loading with all data
					
					<div class="row">

						<div class="col-4">
							<label for="dsc"> uom model</label>
						</div>

						<div class="col-6">

							<form:select path="uom.uomId">

								<form:option value="">--select---</form:option>
								<form:options items="${uoms}" itemLabel="uomModel"
									itemValue="uomId" />




							</form:select>

						</div>
					</div>

 --%>
 
 
                             <div class="row">

						<div class="col-4">
							<label for="dsc"> uom model</label>
						</div>

						<div class="col-6">

							<form:select path="uom.uomId">

								<form:option value="">--select---</form:option>
								<form:options items="${uoms}"  />




							</form:select>

						</div>
					</div>
 

					<div class="row">

						<div class="col-4">
						OrderMethod-mode :
						
						</div>

						<div class="col-6">

							<form:select path="odm.oid" cssClass="form-control">

								<form:option value="">--select--</form:option>

								<form:options items="${odms}" itemLabel="orderCode" itemValue="oid" />


							</form:select>


						</div>




					</div>
					<br>


					<div class="row">

						<div class="col-4">

							<a href="showall">show all data</a>

						</div>

						<div class="col-6">

							<input type="submit" value="create Item" class="btn btn-success">



						</div>

					</div>





				</form:form>


				${savemessage}
			</div>
			<!-- body -->


		</div>
		<!--  card -->


	</div>
	<!--  container -->

</body>
</html>