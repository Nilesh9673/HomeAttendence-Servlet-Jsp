<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="userLogin" method="post">
		username:-<input type="text" name="username"> <br> <br>
		password:-<input type="password" name="password"><br> <br>
		<button type="submit">LOGIN</button>
		<button type="button">
			<a href="SaveUser.jsp"> REGISTER</a>
		</button>
	</form>
</body>
</html>