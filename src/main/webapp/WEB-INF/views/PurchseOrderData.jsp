<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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

Welcome to purchaser Order data page
</div>


<div class="card-body ">

<c:choose>

<c:when test="${empty porder }">

<h4>No data found</h4>

</c:when>


<c:otherwise>

<table class="table table-bordered table-hovere ">

<tr class="thead-dark">
<th>id </th>

<th>Po-code </th>
<th>poMode</th>

<th>shmp-mode</th>

<th>vendor</th>

<th>refNo</th>

<th>qc</th>

<th>odrStatus </th>

<th>desc</th>

<th>operations</th>

</tr>

<c:forEach items="${porder}" var="op">

<tr>
<td> <c:out value="${ op.oid}" /> </td>

<td><c:out value="${op.orderCode }"/>       </td>


<td><c:out value="${op.ordermode }"/>       </td>

<td><c:out value="${ op.shipmentCode}"/>       </td>


<td><c:out value="${op.vendor }"/>       </td>

<td><c:out value="${op.refno }"/>       </td>

<td><c:out value="${op.qc }"/>       </td>

<td><c:out value="${op.orderstatus }"/>       </td>

<td><c:out value="${op.orderdesc }"/>       </td>


<td><a href="delete?id=${op.oid}"><img alt="delete" src=""> </a></td>


</tr>
</c:forEach>

</table>

</c:otherwise>
</c:choose>
</div><!--  body -->

<c:if test="${deletemessage !=null}">

<div class="card-footer bg-warning">

<h4>${deletemessage}</h4>

</div>

</c:if>

</div><!--  card -->


</div><!--  container -->




</body>
</html>