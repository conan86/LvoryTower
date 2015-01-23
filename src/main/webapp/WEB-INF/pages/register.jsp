<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<h2>Create a new user account</h2>
<sf:form method="POST" modelAttribute="userInfo" action="register" enctype="multipart/form-data">
	<table cellpadding="0">
		<tr>
			<th>
				<label for="user_name"> Username : </label>
			</th>
			<td>
				<sf:input path="username" size="15" id="user_name" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<th>
				<label for="password"> Password : </label>
			</th>
			<td>
				<sf:password path="password" size="15" id="password" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<th>
				<label for="age"> age : </label>
			</th>
			<td>
				<sf:input path="age" size="3" id="age" maxlength="3"/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="photo">Photo : </label>
				
			</td>
			<td>
				<input name="photo" type="file" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</sf:form>
</body>
</html>