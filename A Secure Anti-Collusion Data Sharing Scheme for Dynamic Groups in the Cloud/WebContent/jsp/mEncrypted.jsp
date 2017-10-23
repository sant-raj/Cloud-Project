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
	<form method="post" action="./mUpload.do" enctype="multipart/form-data"
		name="uploadForm">
		<table align="center">




			<tr>
				<td><input id="fileName" type="text" name="fileName" size="30"
					value="${ENCRYPTED_FILE.fileName}" readonly="readonly" /></td>
			</tr>

			<tr>
				<td><TEXTAREA id='output' NAME="content" ROWS="8" cols="32"
						readonly="readonly">${ENCRYPTED_FILE.encryptedContent}</TEXTAREA></td>
			</tr>

			<tr>
				<td><input type="text" name="groupName" size="30"
					value="${ENCRYPTED_FILE.group}" readonly="readonly" /></td>
			</tr>

			<tr>
				<td><input id="fileName" type="text" name="publicKey" size="30"
					value="${ENCRYPTED_FILE.publicKey}" readonly="readonly" /></td>
			</tr>

			<tr>
				<td><input id="upload" type="submit" value="Upload"
					onclick="return fileUploadValidate()"></td>
			</tr>

		</table>
	</form>
</body>
</html>