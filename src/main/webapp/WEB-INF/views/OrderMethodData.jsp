<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<div class="card-header bg-secondary text-white">

	<h2> welcome to order method data page</h2>




</div>

<div class="card-body">

<a href="excelexport">excel-export</a><br>
<a href="piecharreport">report in-pie-char</a>

<c:choose>

<c:when test="${empty vom }">

<h4>no data found</h4>

</c:when>
<c:otherwise>

	<table class="table table-bordered table-hovere">

		<tr class="thead-dark">


			<th>oid</th>

			<th>mode</th>

			<th>odesc</th>

			<th colspan="4">operations</th>



		</tr>
		
	
                <c:forEach items="${vom}" var="om" >
               
               
               <tr>
                       <td> <c:out value="${om.oid}"></c:out></td>
                
                <td> <c:out value="${om.orderMode}"></c:out></td>
                
                <td> <c:out value="${om.orderDesc}"></c:out></td>
                
                <td>  
                
          <a href="omdelete?id=${om.oid}">
          <img alt="delete" src="../resources/images/delete.png" width="20" height="20"/></a></td>
           <td> <a href="omviewone?id=${om.oid}"><img alt="viewone"  src="../resources/images/view.png" width="20" height="20"/></a></td>
                
           <td><a href="omeditone?id=${om.oid}"><img alt="edit"  src="../resources/images/edit.png" width="20" height="20"/></a></td>   
           
           <td><a href="export?id=${om.oid}"><img alt="excel"  src="../resources/images/excel.png" width="20" height="20"/></a></td>  
           
               
  
                          </tr>
                </c:forEach>





      		
	</table>
	</c:otherwise>
	</c:choose>
	</div><!--  body -->
	
	<c:if test="${dmessage != null }">
	<div class="card-footer bg-danger text-white">
	
      ${dmessage}
      
       </div>
      </c:if>
     
      
      </div><!-- card -->
      
      </div><!--  container  -->
</body>
</html>