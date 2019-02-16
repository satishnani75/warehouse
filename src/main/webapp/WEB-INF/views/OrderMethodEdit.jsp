<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<h2>Order method update form</h2>

<form:form action="omupdate" method="post" modelAttribute="orderMethod">

	<pre>
order  id    :<form:input path="oid" readonly="true" />

order mode   :<form:radiobutton path="orderMode" value="Sale" />sale
            
               <form:radiobutton path="orderMode" value="purchase" />purchase



order code   :<form:input path="orderCode" />

exicute type : <form:select path="exeType">
	
              <form:option value=" ">--select--</form:option>
              
              <form:option value="FIFO">FIFO</form:option>
              
              <form:option value="LIFO">LIFO</form:option>
              	
              <form:option value="FCFO">FCFO</form:option>
              
              <form:option value="FEFO">FEFO</form:option>
              
     
</form:select>

order accept :<form:checkbox path="orderAccept" value="mutltimode" />multi-mode
              <form:checkbox path="orderAccept" value="accept return " />accept return
              <form:checkbox path="orderAccept" value="service extend" />service extend
              
              
              
 description :<form:textarea path="orderDesc" />
 
 <input type="submit" value="update ordermethod">
 </pre>

</form:form>
<br>
<h2>${message}</h2>

<a href="omviewall"> view all</a>
<body>

</body>
</html>