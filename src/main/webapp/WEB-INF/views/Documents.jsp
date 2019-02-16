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

<h2>welcome to documents upload page</h2>


<form action="upload" method="post"  enctype="multipart/form-data">


select your file :<input type="file" name="fileObj" ><br>

<input type="submit" value="upload">




</form>

<br>

<table border="1">


<tr>

<th>id</th>
<th>file-name</th>
<th>link</th>
</tr>
<c:forEach items="${list}" var="dn">
<tr>
<td><c:out value="${dn[0]}"></c:out></td>

<td><c:out value="${dn[1]}"></c:out></td>
<td>
  <a href="download?fid=${dn[0]}">download</a>

</td>

</tr>
</c:forEach>
</table>




<p>${message}</p>


</body>
</html>