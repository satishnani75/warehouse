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

<h2> welcome to WhUserTyp edit page </h2>

<pre>

<form:form action="update" method="post" modelAttribute="whuserType">

     user id      :     <form:input path="userId" readonly="true"/>

     User types   :     <form:radiobutton path="utype" value="VENDOR"/>vendor
                        <form:radiobutton path="utype" value="CUSTOMER"/>customer

     user code    :     <form:input path="ucode"/>
     
     user for     :     <form:input path="userfor"/>
     
     user email   :     <form:input path="email"/>
     
     user Contact :     <form:input path="ucontact"/>
     
     user id-type :     <form:select path="idType">
     
                        <form:option value=" ">--select--</form:option>
                        
                        <form:option value="PANCARD">PAN-CARD</form:option>
                        
                        <form:option value="AADHARCARD">AADHAR CARD</form:option>
                        
                        <form:option value="VOTERID">VOTER-ID</form:option>
                        <form:option value="other">Other</form:option>     
     
                         </form:select>
                         
                         
       *if Other  :    <form:input path="otherId"/>
       
       
       Id number  :    <form:input path="idnumber"/> 
       
       <input type="submit" value="update User">                 

</form:form>
</pre>
    ${updatetmessage}

<a href="viewall">view all</a>


</body>

</html>