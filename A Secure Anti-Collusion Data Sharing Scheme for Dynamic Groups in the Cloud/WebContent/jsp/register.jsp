<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./images/cloudHome.png"></link>
<title>Group Member Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/calender.css" />
<script type="text/javascript" src="js/validation.js"></script>
<script src="js/date1.js"></script>
<script src="js/dateUi.js"></script>
<script>
	$(function() {
		$("#datepicker-13").datepicker({
			changeYear : true,
			yearRange : "1980:2016",
			changeMonth : true
		});
		/*  $( "#datepicker-13" ).datepicker("show");  */
	});
</script>
</head>
<body>
	<div id="header">
		<div class="section">

			<ul>
				<li><a href="index.do">home</a></li>
				<li><a href="cloudLogin.do">Cloud</a></li>
				<li><a href="groupManagerLogin.do">G Manager</a></li>
				<li class="selected"><a href="groupMemberLogin.do">G Member</a></li>


			</ul>
		</div>

	</div>
	<div id="body">

		<div>
			<h2>A Secure Anti-Collusion Data Sharing Scheme for Dynamic
				Groups in the Cloud</h2>
			<h3 style="font-family: cursive;">Group Member Registration Page</h3>

			<h3 style="font-family: cursive;">${SIGNUP_STATUS}</h3>

			<form action="./userRegister.do" method="post"
				enctype="multipart/form-data" name="regForm">

				<table align="center" cellpadding="0" cellspacing="1">


					<!----- First Name ---------------------------------------------------------->
					<tr>
						<td width="144" height="35">First Name</td>
						<td width="398"><input type="text" name="First_Name"
							maxlength="30" /> (max 30 characters a-z and A-Z)</td>
					</tr>

					<!----- Last Name ---------------------------------------------------------->
					<tr>
						<td height="35">Last Name</td>
						<td><input type="text" name="Last_Name" maxlength="30" />
							(max 30 characters a-z and A-Z)</td>
					</tr>

					<!----- Date Of Birth -------------------------------------------------------->
					<tr>
						<td height="35">Date of Birth</td>
						<td><input id="datepicker-13" name="dob" type="text"
							class="slimpicker" readonly="readonly" /></td>
					</tr>

					<!----- Location  ---------------------------------------------------------->
					<tr>
						<td height="35">Location</td>
						<td><input type="text" name="Location" maxlength="30" />
							(characters a-z and A-Z)</td>
					</tr>

					<!----- Email Id ---------------------------------------------------------->
					<tr>
						<td height="35">email ID</td>
						<td><input type="text" name="Email_Id" maxlength="100" /></td>
					</tr>

					<!----- Password Name ---------------------------------------------------------->
					<tr>
						<td height="35">Create Password</td>
						<td><input type="password" name="Password1" maxlength="10" />
							(max 10 characters a-z and A-Z)</td>
					</tr>

					<tr>
						<td height="35">Confirm Password</td>
						<td><input type="password" name="Password2" maxlength="10" />
							(max 10 characters a-z and A-Z)</td>
					</tr>

					<!----- Submit and Reset ------------------------------------------------->
					<tr>

						<td></td>
						<td height="35"><div align="right">
								<input type="submit" value="Submit"
									onclick="return regFormValidate()"></input>
							</div></td>
					</tr>
				</table>
			</form>

			<p style="font-family: cursive;">
				Already Member? <a href="groupMemberLogin.do">Login</a>
			</p>
		</div>
	</div>
	<div id="footer">
		<div>

			<p>&copy; Cluster Info Solution.</p>
		</div>
	</div>
</body>
</html>