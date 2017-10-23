
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script type="text/javascript" src="../js/validation.js"></script>
</head>

<body>
	<p>Group Uploads...!</p>

	<h3 style="font-family: cursive;">${DELETE_STATUS}</h3>
	<form action="./groupUploads.do" method="post" name="groupUploadsForm">

		<table width="186" border="0" cellpadding="0" cellspacing="0">

			<tr>

				<td width="186"><select name="groupName">
						<option>--GroupName--</option>
						<c:forEach var="details" items="${GROUPS}">
							<option><c:out value="${details.value}" /></option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td height="33"><div align="center">
						<input type="submit" value="Submit"
							onclick="return groupUploadsFormValidate()" />
					</div></td>

			</tr>
		</table>
	</form>

	<!-- All Groups -->
	<c:if test="${PATH == '/jsp/groupUploads.do'}">
		<h3 style="font-family: cursive;">${STATUS}</h3>
		<table border="1" width="98%" cellspacing="0">
			<thead style="color: black;">
				<tr>
					<th>SI NO</th>
					<th>Added By</th>
					<th>File Name</th>
					<th>Public Key</th>
					<th>Added Date</th>
					<th>Rank</th>
					<th>Delete File</th>

				</tr>
			</thead>
			<tbody style="color: black;">




				<c:forEach var="details" items="${GROUP_UPLOADS}">
					<tr>
						<td><div align="center">
								<c:out value="${details.id}" />
							</div></td>

						<td><div align="center">
								<c:out value="${details.uploadBy}" />
							</div></td>
						<td><div align="center">
								<c:out value="${details.fileName}" />
							</div></td>

						<td><div align="center">
								<c:out value="${details.publicKey}" />
							</div></td>
						<td><div align="center">
								<c:out value="${details.date}" />
							</div></td>

						<td><div align="center">
								<c:out value="${details.rank}" />
							</div></td>

						<td><div align="center">
								<a href="./delete.do?id=<c:out value="${details.id}"/>">Delete</a>
							</div></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>

</body>
</html>
