<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Welcome to Ekart</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
			</form>

			<h2>
				Welcome ${sessionScope.userName} ${sessionScope.userId}, ${message}
				| <a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>

	<div class="container">
		<h2>
			<a href="/${sessionScope.userId}/update">Modify Account Details</a>
		</h2>
		<h2>
			<a href="/${sessionScope.userId}/address">Manage Addresses</a>
		</h2>
		<p>${success}${error}</p>
		<c:if test="${user!=null}"><jsp:include
				page="Account/modifyAccount.jsp" /></c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
