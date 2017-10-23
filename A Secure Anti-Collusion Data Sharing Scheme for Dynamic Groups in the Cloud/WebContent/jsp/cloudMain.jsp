<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/cloudHome.png"></link>
<title>${CLOUD}</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div id="header">
		<div class="section">

			<ul>
				<li><a href="groups.do">Groups</a></li>
				<li><a href="groupMembers.do">Members</a></li>
				<li><a href="uploads.do">Uploads</a></li>
				<li><a href="transactions.do">Transactions</a></li>
				<li><a href="cloudMain.do">Main</a></li>
				<li><a href="cloudLogout.do">Logout</a></li>


			</ul>
		</div>
		<!-- <div class="article">
			<img src="images/great-hairstyle.jpg" alt="">

		</div> -->
	</div>
	<div id="body">

		<div>
			<h2>A Secure Anti-Collusion Data Sharing Scheme for Dynamic
				Groups in the Cloud</h2>

			<c:if test="${PATH == '/cloudMain.do'}">
				<div align="center">
					<iframe width="960" height="290" scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/groups.do'}">
				<div align="center">
					<iframe src="jsp/groups.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/groupMembers.do'}">
				<div align="center">
					<iframe src="jsp/groupMembers.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/uploads.do'}">
				<div align="center">
					<iframe src="jsp/uploads.jsp" width="960" height="290"
						scrolling="auto"></iframe>
				</div>
			</c:if>

			<c:if test="${PATH == '/transactions.do'}">
				<div align="center">
					<iframe src="jsp/transactions.jsp" width="960" height="290"
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