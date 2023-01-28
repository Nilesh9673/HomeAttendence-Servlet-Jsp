<%@page import="com.jsp.dto.UserDto"%>
<%@page import="com.jsp.dto.ReportDetail"%>
<%@page import="com.jsp.service.UserService"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.jsp.service.ReportService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="savereport" method="post">
		<%
		HttpSession httpSession = request.getSession();
		int id = (int) httpSession.getAttribute("id");
		int rid = (int) httpSession.getAttribute("rid");

		UserService userService = new UserService();
		UserDto userDto = userService.getById(id);
		ReportService reportService = new ReportService();
		int flag = 0;
		httpSession.setAttribute("flag", flag);

		ReportDetail rd1 = reportService.getReportById(rid);
		%>
		User name:- <b><%=userDto.getUsername()%></b> <br> <br>
		DATE:- <b><%=LocalDate.now()%></b> <br> <br> Time :- <b><%=LocalTime.now()%></b>
		<br> <br>
		<%
		if (flag == 0 && rd1.getSign_in() == null) {
		%>
		<button type="submit">SIGN IN</button>
		<%
		} else {
		%>
		<button type="submit">SIGN OUT</button>
		<%
		}
		%>
		<br> <br>
	</form>
	<button type="button">
		<a href="UserAllReport.jsp">VIEW REPORT</a>
	</button>
	<br>
	<a href="/Home-Attendance/userLogout">LOGOUT</a>
</body>
</html>