<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modify the Address</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<form:form method="POST" modelAttribute="command" action="/${sessionScope.userId}/address/${modifyAddress.id}/modify" 
			class="form-signin">
			<h3 class="form-signin-heading">Edit the Address</h3>

			<spring:bind path="addressLine">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="addressLine" class="form-control"
						value="${modifyAddress.addressLine}" autofocus="true"></form:input>
					<form:errors path="addressLine"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="city">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="city" class="form-control"
						value="${modifyAddress.city}" autofocus="true"></form:input>
					<form:errors path="city"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="state">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:select path="state" class="form-control"
						required="true" itemValue="${modifyAddress.state}">
						<form:options items="${states}" />
					</form:select>
				</div>
			</spring:bind>
			<spring:bind path="phoneNumber">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="phoneNumber" class="form-control"
						value="${modifyAddress.phoneNumber}" autofocus="true"></form:input>
					<form:errors path="phoneNumber"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="pin">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="pin" class="form-control"
						value="${modifyAddress.pin}" autofocus="true"></form:input>
					<form:errors path="pin"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			<a class="btn btn-lg btn-primary btn-block"
				href="${contextPath}/${sessionScope.userId}/address">Cancel</a>
		</form:form>

	</div>

</body>
</html>