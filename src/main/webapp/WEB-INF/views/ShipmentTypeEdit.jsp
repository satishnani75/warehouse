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

<h2>well come to shipment type update  page</h2>



<form:form action="update" method="post" modelAttribute="shipmentType">

<pre>
 
 id            :<form:input path="id" readonly="true"/>
 
shipment mode  :<form:select path="shipmentMode">


               <form:option value="">--select--</form:option>
               <form:option value="AIR">Air</form:option>
               <form:option value="TRUCK">TRUCK</form:option>
               <form:option value="SHIP">SHIP</form:option>

</form:select>

shipment mode  :<form:input path="shipmentCode"/>

enable shipmet :<form:select path="enableShipment">

                        <form:option value=" ">--select--</form:option>

                        <form:option value="YES">yes</form:option>
                        
                        <form:option value="NO">no</form:option>

</form:select>

shipmetn grade : <form:radiobutton path="shipmentGrade" value="A"/>A
                 <form:radiobutton path="shipmentGrade" value="B"/>B
                 <form:radiobutton path="shipmentGrade" value="C"/>C
                 
                 
  description  :<form:textarea path="shipdesc"/>  
  
  
  <input type="submit" value=" update shipment"> 
  
  </pre>            

</form:form>



${message }


<br>


<a href="all" >view all</a>



</body>
</html>