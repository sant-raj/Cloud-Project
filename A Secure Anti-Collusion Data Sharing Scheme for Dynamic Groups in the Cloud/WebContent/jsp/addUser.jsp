<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/validation.js"></script>
</head>
<body>

	<form action="./add.do" method="post" name="addUser">

		<table width="144" border="0" cellpadding="0" cellspacing="0">

			<tr>
				<td width="144" height="34"><div align="center">
						<input type="text" name="id" value="${id}" readonly="readonly" />
			  </div></td>


			</tr>
			<tr>
				<td width="144" height="32">
				  <div align="center">
				    <select name="groupName">
				      <option>--GroupName--</option>
				      <c:forEach var="details" items="${GROUPS}">
				        <option>
			            <c:out value="${details.value}" />
			            </option>
			          </c:forEach>
			        </select>
			      </div></td></tr>
			<tr>
				<td height="33"><div align="center">
						<input type="submit" value="Submit"
							onclick="return addUserValidate()" />
					</div></td>

			</tr>
	  </table>
	</form>

</body>
</html>