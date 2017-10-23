<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/validation.js"></script>
</head>
<body>
	<form action="./download.do" method="post" name="downloadForm">

		<table align="center" cellpadding="0" cellspacing="1">

			<tr>
				<td width="114" height="33"><div align="center">File Name
						:</div></td>
				<td width="192"><input type="text" name="fileName"
					maxlength="30" placeholder=".txt only" value="${fileTo.fileName}"
					size="40" /></td>
			</tr>
			<tr>
				<td height="34"><div align="center">Public Key :</div></td>
				<td><input type="text" name="publicKey"
					value="${fileTo.ownerName}" size="40" /></td>
			</tr>

			<tr>
				<td height="36"><div align="center">Private Key :</div></td>
				<td><input type="text" name="privateKey"
					value="${fileTo.privateKey}" size="40" /></td>
			</tr>

			<tr>

				<td colspan="2"><div align="center">
						<input type="submit" value="Download"
							onclick="return downloadValidate()">
					</div></td>
			</tr>
		</table>

	</form>
	<c:if test="${CONTENT == 'Wrong Credential'}">
		<h2 align="center">Wrong credential....!</h2>
	</c:if>

	<c:if test="${CONTENT != 'Wrong Credential'}">
		<c:if test="${CONTENT != null}">
			<h2 align="center">Content</h2>
			<div align="center">
				<p style="color: #4084F5;">
					<textarea id='myTextArea' cols="35" rows="10">${CONTENT}</textarea>
				</p>
				<p style="color: #4084F5;">
					<input id="upload" type="submit" value="Download" onclick='doDL()'>
				</p>
			</div>
		</c:if>
	</c:if>

</body>
</html>