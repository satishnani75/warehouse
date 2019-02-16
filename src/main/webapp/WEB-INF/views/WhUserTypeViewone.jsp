<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>welcome to view-record page </h2>


<table border="1">

<tr>

<td>id</td>

<td>${vone.userId }</td>

</tr>

<tr>

<td>utype</td>

<td>${vone.utype }</td>

</tr>

<tr>

<td>code</td>

<td>${vone.ucode }</td>

</tr>

<tr>

<td>user for</td>

<td>${vone.userfor }</td>

</tr>

<tr>

<td>email</td>

<td>${vone.email }</td>

</tr>


<tr>

<td>contact</td>

<td>${vone.ucontact }</td>

</tr>

<tr>

<td>idtype</td>

<td>${vone.idType }</td>

</tr>

<tr>

<td>otherid</td>

<td>${vone.otherId }</td>

</tr>

<tr>

<td>idnumber</td>

<td>${vone.idnumber }</td>

</tr>

</table>

<a href="viewall"> <-- goback </a>



</body>
</html>