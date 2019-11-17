<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  
  width: 40%;
  padding-left: 5px;
}
/* th[colspan="2"] {
    text-align: center;
    text-decoration: underline;
    padding-right: 50px;
} */
th{
	text-align: center;
    border-bottom-style: solid;
}
</style>
</head>
<body>
	<table>
		<c:forEach items="${addresses}" var="address" varStatus="i">
			<tr>
				<th colspan="2">Address <c:out value="${i.index+1}"/></th>
				<th><a href="/${sessionScope.userId}/address/${address.id}/modify">Edit</a></th>
				<th><a href="/${sessionScope.userId}/address/${address.id}/delete">Delete</a></th>
			</tr>
			<tr>
				<td>Address Line :</td>
				<td><c:out value="${address.addressLine}" /></td>
			</tr>
			<tr>
				<td>Phone no. :</td>
				<td><c:out value="${address.phoneNumber}" /></td>
			</tr>
			<tr>
				<td>Pin Code. :</td>
				<td><c:out value="${address.pin}" /></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><c:out value="${address.state}" /></td>
			</tr>
			<tr>
				<td colspan="4">  <br>	</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>