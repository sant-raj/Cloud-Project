<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/cloudHome.png"></link>
<title>Cloud Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div id="header">
		<div class="section">

			<ul>
				<li><a href="index.do">home</a></li>
				<li class="selected"><a href="cloudLogin.do">Cloud</a></li>
				<li><a href="groupManagerLogin.do">G Manager</a></li>
				<li><a href="groupMemberLogin.do">G Member</a></li>


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
			<h3 style="font-family: cursive;">Cloud Login Page</h3>

			<p style="font-family: cursive; color: red;">${LOGIN_STATUS}</p>

			<form name="loginForm" action="./cLogin.do" method="post">
				<table>
					<tr>
						<td height="33"><div align="right">UserName :</div></td>
						<td><div align="center">
								<input type="text" name="nme" placeholder="USERNAME"></input>
							</div></td>
					</tr>
					<tr>
						<td height="34"><div align="right">Password :</div></td>
						<td><div align="center">
								<input type="password" name="pwd" placeholder="PASSWORD"></input>
							</div></td>
					</tr>
					<tr>
						<td height="40" colspan="2">
							<div align="center">
								<input type="submit" value="login"
									onclick="return LoginFormValidate()"></input>
							</div>
						</td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<div id="footer">
		<div>

			<p>&copy; Cluster Info Solution.</p>
		</div>
	</div>
</body>
</html>