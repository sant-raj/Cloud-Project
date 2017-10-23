<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/cloudHome.png"></link>
<title>${MEMBER}</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div id="header">
		<div class="section">

			<ul>
				<li><a href="profile.do">Profile</a></li>
				<li><a href="mUpload.do">Upload</a></li>
				<li><a href="groupFiles.do">GroupFile</a></li>
				<li><a href="sentRequests.do">Request</a></li>
				<li><a href="download.do">Download</a></li>
				<li><a href="groupMemberMain.do">Main</a></li>
				<li><a href="groupMemberLogout.do">Logout</a></li>

			</ul>
		</div>

	</div>
	<div id="body">

		<div>
			<h2>A Secure Anti-Collusion Data Sharing Scheme for Dynamic
				Groups in the Cloud</h2>

			<c:if test="${PATH == '/groupMemberMain.do'}">
				<div align="center">
					<iframe width="960" height="290" scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/profile.do'}">
				<div align="center">
					<iframe src="jsp/profile.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/mUpload.do'}">
				<div align="center">
					<iframe src="jsp/mUpload.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/groupFiles.do'}">
				<div align="center">
					<iframe src="jsp/groupFiles.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/sentRequests.do'}">
				<div align="center">
					<iframe src="jsp/sentRequests.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/download.do'}">
				<div align="center">
					<iframe src="jsp/download.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

		</div>
	</div>
	<div id="footer">
		<div>
			<p>&copy; Cluster Info Solution.</p>
		</div>
	</div>
</body>
</html>