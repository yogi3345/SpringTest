<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ekart</title>

<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/font-awesome.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/newstyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/responsive.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>"
	type="text/css" media="all" />
<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Favicon -->
<link rel="shortcut icon" href="/resources/travel/InfyGo.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>

<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

</head>
<body>

	<jsp:include page="header.jsp" />
	<c:if test="${home!=null || success!=null || error!=null}">
		<div class="container">
		
		<c:if test="${home!=null}">
			<h3 class="text-center"><code>You are Logged in with User ID - ${sessionScope.userId}</code></h3>
		</c:if>
		
			<p>${success}${errors}</p>
		</div>
	</c:if>
	<c:if test="${showLogin!=null}"><jsp:include page="login.jsp" /></c:if>
	<c:if test="${showRegister!=null}"><jsp:include
			page="registration.jsp" /></c:if>
	<c:if test="${user!=null}"><jsp:include
			page="Account/modifyAccount.jsp" /></c:if>
	<c:if test="${addresses!=null}"><jsp:include
			page="Address/viewAllAddresses.jsp" /></c:if>
	<c:if test="${addAddress!=null}"><jsp:include
			page="Address/addAddress.jsp" /></c:if>
	<c:if test="${modifyAddress!=null}"><jsp:include
			page="Address/modifyAddress.jsp" /></c:if>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>