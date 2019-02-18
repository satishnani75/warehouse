<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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

				<h2> welcome to WhUserType Edit page </h2>

			</div>

			<div class="card-body">

				<form:form action="update" method="post" modelAttribute="whuserType">
				
				
				<div class="row">


						<div class="col-4">

							<label for="userId"> whuser Id </label>

						</div>

						<div class="col-6">


							<form:input path="userId" readonly="true"/> 

						</div>


					</div>
				

					<div class="row">

						<div class="col-4">

							<label for="utype"> User types</label>
						</div>

						<div class="col-6">
							<form:radiobutton path="utype" value="VENDOR" />
							vendor
							<form:radiobutton path="utype" value="CUSTOMER" />
							customer

						</div>

					</div>


					<div class="row">


						<div class="col-4">

							<label for="ucode"> user code </label>

						</div>

						<div class="col-6">


							<form:input path="ucode" cssClass="form-control"/>

						</div>


					</div>


					<div class="row">


						<div class="col-4">

							<label for="userfor"> user for </label>

						</div>

						<div class="col-6">


							<form:input path="userfor" cssClass="form-control"/>

						</div>


					</div>


					<div class="row">


						<div class="col-4">

							<label for="email"> user email </label>

						</div>

						<div class="col-6">


							<form:input path="email" cssClass="form-control" />

						</div>


					</div>


					<div class="row">


						<div class="col-4">

							<label for="ucontact"> user Contact </label>

						</div>

						<div class="col-6">


							<form:input path="ucontact" cssClass="form-control" />

						</div>


					</div>

					<div class="row">


						<div class="col-4">

							<label for="idType"> user id-type : </label>

						</div>

						<div class="col-6">


							<form:select path="idType" cssClass="form-control">

								<form:option value=" ">--select--</form:option>

								<form:option value="PANCARD">PAN-CARD</form:option>

								<form:option value="AADHARCARD">AADHAR CARD</form:option>

								<form:option value="VOTERID">VOTER-ID</form:option>
								<form:option value="other">Other</form:option>

							</form:select>

						</div>


					</div>

					<div class="row">


						<div class="col-4">

							<label for="otherId"> if-other </label>

						</div>

						<div class="col-6">


							<form:input path="otherId" cssClass="form-control" />

						</div>


					</div>


					<div class="row">


						<div class="col-4">

							<label for="idnumber"> Id number : </label>

						</div>

						<div class="col-6">

							<form:input path="idnumber" cssClass="form-control"/>
						</div>


					</div>


					<div class="row">


						<div class="col-4">

							<a href="viewall">view all</a>
						</div>

						<div class="col-6">

							<input class="btn btn-success" type="submit" value="update user">
						</div>


					</div>


				</form:form>
			</div>

			<c:if test="${updatemessage!= null}">


				<div class="card-footer bg-warning">${updatemessage}</div>

			</c:if>


		</div>
		<!-- card  -->
	</div>



</body>

</html>