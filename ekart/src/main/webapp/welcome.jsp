<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
        </form>

        <h2>Welcome ${sessionScope.userName} ${sessionScope.userId}, ${message} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
  </div>
  
  <div class="container">
  		<h2><a href="/${sessionScope.userId}/update">Modify Account Details</a></h2>
  		<p>${userModified}</p>
  		<c:if test="${user!=null}">
  			
  			<div class="container">

	        <form:form method="POST" modelAttribute="command" class="form-signin">
	            <h3 class="form-signin-heading">Modify your Ekart Account</h3>
	            <spring:bind path="name">
	                <div class="form-group ${status.error ? 'has-error' : ''}">
	                    <form:input type="text" path="name" class="form-control" value="${user.name}"
	                                autofocus="true" ></form:input>
	                    <form:errors path="name"></form:errors>
	                </div>
	            </spring:bind>
	            <spring:bind path="email">
	                <div class="form-group ${status.error ? 'has-error' : ''}">
	                    <input type="text" class="form-control" value= "${user.email}"
	                                readonly="readonly"></input>
	                    <form:errors path="email"></form:errors>
	                </div>
	            </spring:bind>
	
	            <spring:bind path="password">
	                <div class="form-group ${status.error ? 'has-error' : ''}">
	                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
	                    <form:errors path="password"></form:errors>
	                </div>
	            </spring:bind>
	
	            <spring:bind path="passwordConfirm">
	                <div class="form-group ${status.error ? 'has-error' : ''}">
	                    <form:input type="password" path="passwordConfirm" class="form-control"
	                                placeholder="Confirm your password"></form:input>
	                    <form:errors path="passwordConfirm"></form:errors>
	                </div>
	            </spring:bind>
	
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	            <a class="btn btn-lg btn-primary btn-block" href="${contextPath}/welcome">Cancel</a>
	        </form:form>

    </div>
  			
  		</c:if>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
