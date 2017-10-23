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
	<p style="font-family: cursive;">All Transactions....!</p>
	<table border="1" width="98%" cellspacing="0">
		<thead>
			<tr>
			<tr>
				<th>SL_NO</th>
				<th>User</th>
				<th>Group</th>
				<th>File Name</th>
				<th>Date</th>
				<th>Transaction</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="details" items="${TRANSACTIONS}">
				<tr>
					<td><div align="center">
							<c:out value="${details.id}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.user}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.groupName}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.fileName}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.date}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.transaction}" />
						</div></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>