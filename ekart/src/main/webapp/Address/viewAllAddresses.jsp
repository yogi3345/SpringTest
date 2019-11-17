<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h3 class="text-center text-capitalize">Registered Addresses</h3><br><br>
				<div class="table-responsive" style="max-height: 450px;">
					<table class="table">
						<c:forEach items="${addresses}" var="address" varStatus="i">
							<tr>
								<th colspan="2">Address <c:out value="${i.index+1}" /></th>
								<th><a
									href="/${sessionScope.userId}/address/${address.id}/modify">Edit</a></th>
								<th><a
									href="/${sessionScope.userId}/address/${address.id}/delete">Delete</a></th>
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
								<td>City :</td>
								<td><c:out value="${address.city}" /></td>
							</tr>
							<tr>
								<td>State :</td>
								<td><c:out value="${address.state}" /></td>
							</tr>
							<tr>
								<td colspan="4"><br></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>