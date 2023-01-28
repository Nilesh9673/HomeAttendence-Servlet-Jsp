<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register User</h1>
	<form action="saveUser" method="post">
		username:-<input type="text" name="username"> <br> <br>
		password:-<input type="password" name="password"><br> <br>
		Email Id:-<input type="email" name="email"><br> <br>
		Phone No:-<input type="number" name="number"><br> <br>
		<button type="submit">REGISTER</button>

		<button type="button">
			<a href="UserLogin.jsp">LOGIN</a>
		</button>

	</form>
</body>
</html>