<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add an Address</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<form:form method="POST" action="/${sessionScope.userId}/address/add" modelAttribute="addAddress"
			class="form-signin">
			<h3 class="form-signin-heading">Add an Address</h3>

			<spring:bind path="addressLine">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:textarea type="text" path="addressLine" class="form-control"
						placeholder="Address" autofocus="true"></form:textarea>
					<form:errors path="addressLine"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="state">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:select path="state" class="form-control"
						required="true" title="Select State">
						<!-- <option>Chennai</option>
								<option>Delhi</option> -->
						<form:option label="--Select_State--" value="" />
						<form:options items="${states}" />
					</form:select>
				</div>
			</spring:bind>
			<spring:bind path="phoneNumber">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="phoneNumber" class="form-control"
						placeholder="Phone No." autofocus="true"></form:input>
					<form:errors path="phoneNumber"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="pin">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="pin" class="form-control"
						placeholder="Pin Code" autofocus="true"></form:input>
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