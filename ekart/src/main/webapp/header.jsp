<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

			<!-- HEADER -->
	<header id="header">


		<nav style="max-height: 70px;" class="navbar st-navbar navbar-fixed-top">

			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#st-navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="logo1" href=""><img
						src="<c:url value='/resources/images/infygonew.PNG'/>" alt=""></a>
						 
				</div>

				<div class="collapse navbar-collapse" id="st-navbar-collapse">
					<div class="">
						<ul class="nav navbar-nav nav-links">

							<li><a href="/">Home</a></li>
							<c:if test="${sessionScope.userId!=null}">
								<li><a href="/${sessionScope.userId}/address/add">Add Address</a></li>
								<li><a href="/${sessionScope.userId}/address">Manage Address</a></li>
							</c:if>
						</ul>
						<ul class="nav navbar-nav navbar-right margintop-5">
							
							<li>
								<c:if test="${sessionScope.userId==null}">
									<a class="btn btn-xs  nav-links-right" href="${pageContext.servletContext.contextPath}/registration"> <span class="glyphicon glyphicon-user"></span>&nbsp;Sign Up</a>	
								</c:if>
								<c:if test="${sessionScope.userId!=null}">
									<a style="text-transform: capitalize;" class="btn btn-xs  nav-links-right " href="/${sessionScope.userId}/update"> <span class="glyphicon glyphicon-user"></span>&nbsp;Hi ${sessionScope.userName}</a>	
								</c:if>
					
							</li>
							<li>
								<c:if test="${sessionScope.userId==null}">
									<a class="btn btn-xs .nav-links-right" href="${pageContext.servletContext.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a>
								</c:if>
								<c:if test="${sessionScope.userId!=null}">
									<a class="btn btn-xs .nav-links-right" href="${pageContext.servletContext.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Logout</a>
								</c:if>
							</li>

						</ul>
					</div>

				</div>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

	</header>
	<!-- /HEADER -->
	<br><br><br><br>

</body>
</html>