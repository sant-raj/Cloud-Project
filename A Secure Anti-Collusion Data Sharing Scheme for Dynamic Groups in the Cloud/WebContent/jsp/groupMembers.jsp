<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./../js/validation.js"></script>
</head>
<body>
	<p style="font-family: cursive;">All Members....!</p>
	<table border="1" width="98%" cellspacing="0">
		<thead>
			<tr>
			<tr>
				<th>SL_NO</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Location</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="details" items="${MEMBERS}">
				<tr>
					<td><div align="center">
							<c:out value="${details.id}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.firstName}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.email}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.location}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.status}" />
						</div></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>