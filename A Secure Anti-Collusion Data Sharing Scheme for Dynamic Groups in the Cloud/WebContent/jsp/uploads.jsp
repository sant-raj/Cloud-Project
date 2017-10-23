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
	<p style="font-family: cursive;">Uploaded Files....!</p>
	<c:forEach var="details" items="${UPLOADS}">
		<p style="font-family: cursive;">Uploaded Files in Cloud
			${details.key}</p>
		<table border="1" width="98%" cellspacing="0">
			<thead style="color: black;">
				<tr>
					<th>SI NO</th>
					<th>Added By</th>
					<th>File Name</th>
					<th>Public Key</th>
					<th>Added Date</th>
					<th>Rank</th>

				</tr>
			</thead>
			<tbody style="color: black;">




				<c:forEach var="detailss" items="${details.value}">
					<tr>
						<td><div align="center">
								<c:out value="${detailss.id}" />
							</div></td>

						<td><div align="center">
								<c:out value="${detailss.uploadBy}" />
							</div></td>
						<td><div align="center">
								<c:out value="${detailss.fileName}" />
							</div></td>

						<td><div align="center">
								<c:out value="${detailss.publicKey}" />
							</div></td>
						<td><div align="center">
								<c:out value="${detailss.date}" />
							</div></td>

						<td><div align="center">
								<c:out value="${detailss.rank}" />
							</div></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach>
</body>