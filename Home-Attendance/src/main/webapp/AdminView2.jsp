<%@page import="com.jsp.dto.ReportDetail"%>
<%@page import="com.jsp.dto.UserDto"%>
<%@page import="java.time.Duration"%>
<%@page import="java.sql.Time"%>

<%@page import="java.time.temporal.TemporalUnit"%>
<%@page import="com.jsp.service.UserService"%>
<%@page import="com.jsp.service.ReportService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession httpSession = request.getSession();
	int id = (int) httpSession.getAttribute("uid");
	ReportService reportService = new ReportService();

	UserService userService = new UserService();
	UserDto user = userService.getById(id);
	%>
	<b><%=user.getUsername()%></b>
	<br>
	<br>
	<form action="AdminLogout" method="get">

		<%
		/* HttpSession httpSession = request.getSession();
		int id = (int) httpSession.getAttribute("uid");
		ReportService reportService = new ReportService(); */
		List<ReportDetail> report = reportService.getAllReport();
		Duration duration = null;
		for (ReportDetail rd : report) {
			if (rd.getUserId() == id) {
		%>
		DATE :- <b><%=rd.getDate()%></b>

		<%
		if (rd.getSign_in() != null) {
		%>
		<br> SIGN IN:- <b><%=rd.getSign_in()%></b>
		<%
		}
		if (rd.getSign_out() != null) {
		%>

		<br> SIGN OUT:- <b><%=rd.getSign_out()%></b>
		<%
		}
		if (rd.getSign_in() == null && rd.getSign_out() == null) {
		%>
		<br>absent
		<%
		} else if (rd.getSign_in() != null && rd.getSign_out() == null) {
		%><br> absent
		<%
		} else {
		duration = Duration.between(rd.getSign_out(), rd.getSign_in());
		%>
		<br>present
		<%
		}
		%>
		<br> Duration:-
		<%
		int t = (int) duration.getSeconds();
		int min = t / 60;
		int sec = t % 60;
		%>
		<%=min%>.<%=sec%>
		sec <br> =================================== <br>
		<%
		}
		}
		%>
		</table>
		<button type="submit">Logout</button>
	</form>
	<button type="button">
		<a href="AdminView1.jsp">Back</a>
	</button>

</body>
</html>