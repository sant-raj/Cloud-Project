<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/cloudHome.png"></link>
<title>${GM}</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div id="header">
		<div class="section">

			<ul>
				<li><a href="addGroup.do">AddGroup</a></li>
				<li><a href="gmUpload.do">Upload</a></li>
				<li><a href="groupUploads.do">Uploads</a></li>
				<li><a href="users.do">User</a></li>
				<li><a href="userRequests.do">Request</a></li>
				<li><a href="revokedUser.do">RevokeUser</a></li>



			</ul>
		</div>

	</div>
	<div id="body">

		<div>
			<h2>A Secure Anti-Collusion Data Sharing Scheme for Dynamic
				Groups in the Cloud</h2>

			<c:if test="${PATH == '/groupManagerMain.do'}">
				<div align="center">
					<iframe width="960" height="290" scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/addGroup.do'}">
				<div align="center">
					<iframe src="jsp/addGroup.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/gmUpload.do'}">
				<div align="center">
					<iframe src="jsp/upload.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/groupUploads.do'}">
				<div align="center">
					<iframe src="jsp/groupUploads.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/users.do'}">
				<div align="center">
					<iframe src="jsp/users.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/userRequests.do'}">
				<div align="center">
					<iframe src="jsp/userRequests.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/revokedUser.do'}">
				<div align="center">
					<iframe src="jsp/revokedUser.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<a href="groupManagerMain.do">Main</a><br /> <br /> <a
				href="groupManagerLogout.do">Logout</a><br />

		</div>
	</div>
	<div id="footer">
		<div>

			<p>&copy; Cluster Info Solution.</p>
		</div>
	</div>
</body>
</html>