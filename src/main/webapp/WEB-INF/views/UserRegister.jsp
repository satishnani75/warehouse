<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
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

<div class="card-header bg-info">
<h2>welcome to user registration page</h2>


</div>

<div class="card-body">

<form:form action="insert" method="post" modelAttribute="userObj">


 <div class="row">
<div class="col-4">
<label for="uname">  enter your name</label>
</div>
<div class="col-6">
  <form:input path="uname"/>
</div>
</div>               

<div class="row">
<div class="col-4">
<label for="email">  enter your email</label>
</div>
<div class="col-6">
  <form:input path="email"/>
</div>
</div> 


<div class="row">
<div class="col-4">
<label for="mno">   enter your mobile no</label>
</div>
<div class="col-6">
  <form:input path="mno"/>
</div>
</div> 


<div class="row">
<div class="col-4">
<label for="pwd">  enter your password</label>
</div>
<div class="col-6">
  <form:input path="pwd"/>
</div>
</div> 


<div class="row">
<div class="col-4">
<label for="roles">Role</label>
</div>
<div class="col-6">
  <form:checkbox path="roles" value="ADMIN"/>Admin

  <form:checkbox path="roles" value="USER"/>AppUser
</div>
</div> 

<div class="row">
<div class="col-4">
<a href="viewall">view all data</a>
</div>
<div class="col-6">
  <input class="btn btn-success" type="submit" value="register user">  
</div>
</div> 
            
                       
                     
</form:form>

</div>



<c:if test="${savemessage !=null}">

<div class="card-footer bg-success">
${savemessage}

</div>


</c:if>





</div>
</div>
</body>
</html>