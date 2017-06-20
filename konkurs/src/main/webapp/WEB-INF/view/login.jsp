<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function validate() {
		if (document.f.username.value == "" && document.f.password.value == "") {
			alert("Username and password are required");
			document.f.username.focus();
			return false;
		}
		if (document.f.username.value == "") {
			alert("Username is required");
			document.f.username.focus();
			return false;
		}
		if (document.f.password.value == "") {
			alert("Password is required");
			document.f.password.focus();
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form name='f' action="login" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>