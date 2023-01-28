
<%@page import="com.jsp.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All User</h1>
	<form action="getuserbyid" method="get">
		Enter User Id:-<input type="number" name="number"><br> <br>
		<button type="submit">GetUserReport</button>
	</form>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>UserName</th>
				<th>Email</th>
				<th>Password</th>
				<th>Contact no</th>
			</tr>
		</thead>
		<%
		UserService userService = new UserService();
		List<UserDto> user = userService.getAllUser();
		for (UserDto u : user) {
		%>
		<tbody>
			<tr>
				<th><%=u.getId()%></th>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getCno()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>

	<button type="button">
		<a href="/Home-Attendance/AdminLogout">LOGOUT</a>
	</button>
</body>
</html>