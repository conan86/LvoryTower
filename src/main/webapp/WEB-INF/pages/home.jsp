<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Welcome</title></head>
<body>
	<h1>${message} : ${username}</h1>
	
	<table cellspacing="15">
		<tr>
			<th>
				id
			</th>
			<th>
				user name
			</th>
			<th>
				password
			</th>
			<th>
				age
			</th>
			<th>
				photo path
			</th>
		</tr>
		<c:forEach var="user" items="${userList}" >
		<tr>
			<td>
				<c:out value="${user.id}"></c:out>
			</td>
			<td>
				<c:out value="${user.username}"></c:out>
			</td>
			<td>
				<c:out value="${user.password}"></c:out>
			</td>
			<td>
				<c:out value="${user.age}"></c:out>
			</td>
			<td>
				<c:out value="${user.photoPath}"></c:out>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
