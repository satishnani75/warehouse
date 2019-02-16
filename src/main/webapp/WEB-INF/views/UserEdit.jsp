<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> welcome to user edit page </h2>

<pre>

<form:form action="update" method="post" modelAttribute="userEdit">


 user id           :  <form:input path="uid" readonly="true"/>
 
 enter your name   :   <form:input path="uname"/>
 
 
 enter your email  :   <form:input path="email"/>
 
 
 enter your mobile no : <form:input path="mno"/>
 
 
 enter your password :  <form:input path="pwd"/>
 
 
 Role                :<form:checkbox path="roles" value="ADMIN"/>Admin

                       <form:checkbox path="roles" value="USER"/>AppUser
                       
                       
                       
         <input type="submit" value="update user">              
</form:form>



</pre>

${updatemessage}
</body>
</html>