<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Manage your Address</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		
		<h2>
			<a href="/welcome">Back to Welcome Page</a>
		</h2>
		<h2>
			<a href="/${sessionScope.userId}/address">View All Addresses</a>
		</h2>
		<h2>
			<a href="/${sessionScope.userId}/address/add">Add Address</a>
		</h2>
		<p>${success}${error}</p>
		
		<p><br></p><p><br></p>

		<c:if test="${addAddress==null && modifyAddress==null}"><jsp:include
				page="Address/viewAllAddresses.jsp" /></c:if>
		<c:if test="${addAddress!=null}"><jsp:include
				page="Address/addAddress.jsp" /></c:if>
		<c:if test="${modifyAddress!=null}"><jsp:include
				page="Address/modifyAddress.jsp" /></c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html> --%>