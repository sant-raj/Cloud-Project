
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="../js/validation.js"></script>
</head>
<body>
	<p>${UPLOAD_STATUS}</p>
	<form method="post" action="./encrypt.do" enctype="multipart/form-data"
		name="fileEncrypt">
		<table align="center">



			<tr>
				<td><input id="file" type='file' 
					onchange='openFile(event)'></td>
			</tr>
			
			<!-- accept='text/plain' -->
			
			<tr>
				<td><input id="fileName" type="text" name="fileName" size="30"
					readonly="readonly" placeholder="fileName.txt only" /></td>
			</tr>

			<tr>
				<td><TEXTAREA id='output' NAME="content" ROWS="8" cols="32"
						readonly="readonly"></TEXTAREA></td>
			</tr>

			<tr>
				<td><select name="groupName">
						<option>--GroupName--</option>
						<c:forEach var="details" items="${GROUPS}">
							<option><c:out value="${details.value}" /></option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><input id="upload" type="submit" value="Encrypt"
					onclick="return fileEncryptValidate()"></td>
			</tr>

		</table>
	</form>
</body>
</html>