/** Common Login Validation */
function LoginFormValidate() {
	var username = document.forms.loginForm.nme.value;
	var password = document.forms.loginForm.pwd.value;

	if (username == null || username == "") {
		alert("UserName Should not be null or empty ");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (/\s/g.test(username)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (password == null || password == "") {
		alert("Password Should not be null or empty ");
		document.forms.loginForm.pwd.focus();
		return false;
	}

	if (/\s/g.test(password)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.pwd.focus();
		return false;
	}

}

/** Group Manager Validation */
function addGroupFormValidate() {
	var groupName = document.forms.addGroupForm.groupName.value;

	if (groupName == null || groupName == "") {
		alert("Group Name Should not be null");
		document.forms.addGroupForm.groupName.focus();
		return false;
	}

}

function fileEncryptValidate() {

	var file = document.forms.fileEncrypt.file.value;

	if (file == null || file == "") {
		alert("Please select file");
		document.forms.fileEncrypt.file.focus();
		return false;
	}

	var groupName = document.forms.fileEncrypt.groupName.value;

	if (groupName == "--GroupName--") {
		alert("Group Name should not be empty");
		document.forms.fileEncrypt.groupName.focus();
		return false;
	}

}

function groupUploadsFormValidate() {
	var groupName = document.forms.groupUploadsForm.groupName.value;

	if (groupName == "--GroupName--") {
		alert("Group Name Should not be null");
		document.forms.groupUploadsForm.groupName.focus();
		return false;
	}

}

function addUserValidate() {
	var groupName = document.forms.addUser.groupName.value;

	if (groupName == "--GroupName--") {
		alert("Group Name Should not be null");
		document.forms.addUser.groupName.focus();
		return false;
	}

}

/** ******************* Group User Validation ******************* */
function regFormValidate() {

	var fname = document.forms.regForm.First_Name.value;

	var name = /^\S/;

	if (fname == null || fname == "") {
		alert("First_Name Should not be null or empty ");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (!name.test(fname)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (isNaN(fname) == false) {
		alert("Please give Characters in First_Name Field");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (fname.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	var lname = document.forms.regForm.Last_Name.value;

	if (lname == null || lname == "") {
		alert("Last_Name Should not be null or empty ");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (!name.test(lname)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (isNaN(lname) == false) {
		alert("Please give Characters in Last_Name Field");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (lname.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	var date = document.forms.regForm.dob.value;

	if (date == null || date == "") {
		alert("Date Should not be null or empty ");
		document.forms.regForm.dob.focus();
		return false;
	}

	var email = document.forms.regForm.Email_Id.value;
	var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	if (email == null || email == "") {
		alert("Email_Id Should not be null or empty ");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	if (!name.test(email)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	if (!mail.test(email)) {
		alert("Please give valid email Id");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	var location = document.forms.regForm.Location.value;
	var name = /^\S/;

	if (location == "" || location == null) {
		alert("Location Should not be null or empty");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (isNaN(location) == false) {
		alert("Please give Characters in Location Field");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (location.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (location.indexOf(" ") >= 0) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Location.focus();
		return false;
	}

	var pwd1 = document.forms.regForm.Password1.value;

	if (pwd1 == null || pwd1 == "") {
		alert("Password Should not be null or empty ");
		document.forms.regForm.Password1.focus();
		return false;
	}

	if (!name.test(pwd1)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Password1.focus();
		return false;
	}

	if (pwd1.length < 6) {
		alert("Minimum of 6 Characters required");
		document.forms.regForm.Password1.focus();
		return false;
	}

	var pwd2 = document.forms.regForm.Password2.value;

	if (pwd2 != pwd1) {
		alert("Password Mismatch\n Please Enter same Password");
		document.forms.regForm.Password2.focus();
		return false;
	}
}

function downloadValidate() {

	var fileName = document.forms.downloadForm.fileName.value;

	if (fileName == null || fileName == "") {
		alert("File Name Should not be Null, It Should be .txt file");
		document.forms.downloadForm.fileName.focus();
		return false;
	}

	var publicKey = document.forms.downloadForm.publicKey.value;

	if (publicKey == null || publicKey == "") {
		alert("PublicKey Should not be null or empty");
		document.forms.downloadForm.publicKey.focus();
		return false;
	}

	var privateKey = document.forms.downloadForm.privateKey.value;

	if (privateKey == null || privateKey == "") {
		alert("PrivateKey Should not be null or empty");
		document.forms.downloadForm.privateKey.focus();
		return false;
	}

}

var openFile = function(event) {
	var input = event.target;
	onchange = document.getElementsByName('fileName')[0].value = document
			.getElementById('file').value.replace(/^.*[\\\/]/, '');
	var reader = new FileReader();
	reader.onload = function() {
		var text = reader.result;
		var node = document.getElementById('output');
		node.innerText = text;
		console.log(reader.result.substring(0, 200));
	};
	reader.readAsText(input.files[0]);
};

function doDL() {

	var s = document.getElementById("myTextArea").value;
	function dataUrl(data) {
		return "data:x-application/text," + escape(data);
	}
	window.open(dataUrl(s));
}