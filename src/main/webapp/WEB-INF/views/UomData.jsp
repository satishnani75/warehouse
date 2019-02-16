<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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


<div class="card-header bg-primary text-white">
<h2> Uom data page</h2>

</div>


<a href="excelexport">excel-export</a>


<div class="card-body">

<c:choose>

<c:when test="${empty ulist }">

<h4>NO data found</h4>
</c:when>
<c:otherwise>

<table class="table table-bordered" >

<tr class="thead-dark">

 

<th>uid</th>

<th>utype</th>

<!-- <th>umodel</th>

<th>udesc</th> -->


<th colspan="4">options</th>





</tr>

<c:forEach items="${ulist}" var="um" >
<tr>



<td><c:out value="${um.uomId}"/>      </td>

<td>   <c:out value="${um.uomType}"></c:out>     </td>

<%-- <td>   <c:out value="${um.uomModel}"></c:out>     </td>

<td>   <c:out value="${um.dsc}"></c:out>     </td> --%>
<td>

<a href="udelete?uid=${um.uomId}"><img alt="delete" src="../resources/images/delete.png" width="20" height="20"/></a>

</td>

<td> <a href="viewall?uid=${um.uomId}"><img alt="viewall" src="../resources/images/view.png"width="20" height="20"> </a>

<td><a href="ueditone?uid=${um.uomId}"><img alt="edit" src="../resources/images/edit.png"width="20" height="20"></a></td>

<td> <a href="export?uid=${um.uomId}"><img alt="excel" src="../resources/images/excel.png"width="20" height="20"></a></td>

</tr>


</c:forEach>


</table>
</c:otherwise>
</c:choose>

</div>

<c:if test="${message !=null }">
<div class="card-footer bg-danger text-white">
${message}
</div>
</c:if>
</div>
</div>
</body>
</html>