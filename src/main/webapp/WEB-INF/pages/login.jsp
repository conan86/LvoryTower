<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>${message}</h1>
<h1>
	Login
</h1>
<form action="login" method="post" >
	<div>
		<div>
			<span title="username">UserName</span>
		</div>
		<div>
			<input type="text" name="username"/>
		</div>
	</div>
	<div>
		<div>
			<span title="password">Password</span>
		</div>
		<div>
			<input type="password" name="password"/>
		</div>
	</div>
	<div>
		<input type="submit" value="Submit">
	</div>
</form>

<font>If you don't have a user account, please register </font>
<a href="register?new"> Register</a>
</body>
</html>