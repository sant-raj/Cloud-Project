<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p style="font-family: cursive;">All Groups....!</p>
	<table border="1" width="30%" cellspacing="0">
		<thead>
			<tr>

				<th>SI NO</th>
				<th>Group Name</th>
			</tr>
		</thead>
		<tbody>




			<c:forEach var="details" items="${GROUPS}">
				<tr>
					<td><div align="center">
							<c:out value="${details.key}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.value}" />
						</div></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>