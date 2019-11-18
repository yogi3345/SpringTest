<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Account</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<form:form method="POST" modelAttribute="command" class="form-signin">
			<h3 class="form-signin-heading text-center">Modify Account</h3><br>
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="name" class="form-control"
						value="${user.name}" autofocus="true"></form:input>
					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="email" class="form-control"
						value="${user.email}" readonly="true" autofocus="true"></form:input>
					<%-- <input type="text" class="form-control" value="${user.email}"
						readonly="readonly"></input> --%>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<%-- <spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input  type="hidden" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind> --%>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			<a class="btn btn-lg btn-primary btn-block"
				href="${contextPath}/">Cancel</a>
		</form:form>

	</div>

</body>
</html>