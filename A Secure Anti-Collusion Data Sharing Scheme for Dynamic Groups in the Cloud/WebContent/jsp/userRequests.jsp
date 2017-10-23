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
	<p style="font-family: cursive;">File Request Status....!</p>
	<table border="1" width="98%" cellspacing="0">
		<thead>
			<tr>
			<tr>
				<th>File Id</th>
				<th>File Name</th>
				<th>Group Name</th>
				<th>Requested Name</th>
				<th>Request Date</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="details" items="${USER_REQUESTS}">

				<tr>
					<td><div align="center">
							<c:out value="${details.fileId}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.fileName}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.groupName}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.userEmail}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.date}" />
						</div></td>

					<td><div align="center">

							<c:if test="${details.status != 'Pending'}">
								<c:out value="${details.status}" />
							</c:if>
							<c:if test="${details.status == 'Pending'}">
								<a
									href="./permit.do?fileId=<c:out value="${details.fileId}"/>&userEmail=<c:out value="${details.userEmail}"/>"><c:out
										value="${details.status}" /></a>
							</c:if>
						</div></td>




				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>