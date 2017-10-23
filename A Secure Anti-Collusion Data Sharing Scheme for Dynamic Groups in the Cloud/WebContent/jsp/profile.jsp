<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="50%" border="1" align="center" cellpadding="0"
		cellspacing="0" style="color: BLACK">



		<tr>

			<td width="43%" height="40"><div align="right">User Id
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td width="57%"><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.id}" />
				</div></td>
		</tr>

		<tr>

			<td height="40"><div align="right">User Name
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.firstName} ${PROFILE.lastName}" />
				</div></td>
		</tr>

		<tr>

			<td height="40"><div align="right">Date of Birth
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.dateOfBirth}" />
				</div></td>
		</tr>
		<tr>

			<td height="40"><div align="right">Email
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.email}" />
				</div></td>
		</tr>

		<tr>
			<td height="40"><div align="right">Location
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.location}" />
				</div></td>
		</tr>

		<tr>
			<td height="40"><div align="right">Status
					:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:out value="${PROFILE.status}" />
				</div></td>
		</tr>
	</table>


</body>
</html>