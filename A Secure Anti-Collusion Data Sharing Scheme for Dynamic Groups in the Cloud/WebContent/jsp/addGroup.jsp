
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script type="text/javascript" src="../js/validation.js"></script>
</head>

<body>
	<p>Add Groups Here...!</p>
	<p>${STATUS}</p>

	<form action="./addGroup.do" method="post" name="addGroupForm">

		<table width="186" border="0" cellpadding="0" cellspacing="0">

			<tr>

				<td width="186"><div align="center">
						<input type="text" name="groupName" maxlength="30"
							placeholder="            Group Name" />
					</div></td>
			</tr>
			<tr>
				<td height="33"><div align="center">
						<input type="submit" value="Submit"
							onclick="return addGroupFormValidate()" />
					</div></td>

			</tr>
		</table>
	</form>


	<p>
		<a href="groups.do">Groups</a>
	</p>

	<!-- All Groups -->
	<c:if test="${PATH == '/jsp/groups.do'}">

		<table border="1" width="30%" cellspacing="0">
			<thead style="color: black;">
				<tr>

					<th>SI NO</th>
					<th>Group Name</th>
				</tr>
			</thead>
			<tbody style="color: black;">




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

	</c:if>

</body>
</html>
