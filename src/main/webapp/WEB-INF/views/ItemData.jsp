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

	<%@include file="UserMenu.jsp"%>
	
	<div class="container">

	<div class="card">


		<div class="card-header bg-primary text-white">


			<h2>welcome to Item data page</h2>

		</div>
		
		<div class="card-body">
		
		<a href="excelExp">Export Excel</a><br>
	<a href="pdfexport">pdf-export</a>
	<br>

	<a href="piechartdata">pie chat-data</a>
		
		<c:choose>
		
		<c:when test="${empty list }">
		
		<h4>NO data found</h4>
		</c:when>
	
		<c:otherwise>

		<table class="table table-bordered table-hover">

			<tr  class="thead-dark">

				<th bgcolor="blue">id</th>
				<th>code</th>
				<th>width</th>
				 <th>lenght</th>
                <th>hight</th> 
				<th>cost</th>
				<th>b.crncy</th> 
				<th>desc</th>
				<th>uom</th>
				<th>odr-method</th>
				
				<th colspan="3">operations</th>
			</tr>

			<c:forEach items="${list}" var="st">
				<tr>

					<td><c:out value="${st.id}" /></td>

					<td><c:out value="${st.itemcode}" /></td>

					<td><c:out value="${st.width}" /></td>

					<td><c:out value="${st.length}"/></td>
      
                     <td><c:out value="${st.height}"/></td>

					<td><c:out value="${st.cost}" /></td>
					
					<td><c:out value="${st.baseCurrency}"/></td>

					<td><c:out value="${st.descrep}" /></td>
					
					<td><c:out value="${st.uom.uomModel }"></c:out></td>
					
					<td><c:out value="${st.odm.orderCode }"></c:out></td>

					<td><a href="deletitem?sid=${st.id}"> <img alt="delete"
							src="../resources/images/delete.png" width="20" height="20" /></a></td>

					<%-- <td><a href="viewone?sid=${st.id}"> <img alt="view"
							src="../resources/images/view.png" width="20" height="20" /></a></td> --%>
							
							
					<td><a href="getone?id=${st.id}"> <img alt="edit"
							src="../resources/images/edit.png" width="20" height="20" /></a>
					
					
					<%-- <td><a href="exportExcelOne?sid=${st.id}"> <img
							src="../resources/images/excel.png" height="20" width="20" />
					</a></td> --%>

					<td><a href="pdfone?sid=${st.id}"> <img
							src="../resources/images/pdf.png" height="20" width="20" />
					</a></td>

				</tr>

			</c:forEach>

		</table>
		</c:otherwise>
		
		</c:choose>
		</div><!--  body end -->

	</div><!--  header end -->
	
	<c:if test="${deletemsg!=null }">
	
	<div class="card-footer bg-danger text-white">

	<p>${deletemsg}</p>
</div>
	
	</c:if>
	
	
	


</div>
</body>
</html>