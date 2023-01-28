<%@page import="com.jsp.dto.UserDto"%>
<%@page import="com.jsp.dto.ReportDetail"%>
<%@page import="com.jsp.service.UserService"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
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

	<%
	HttpSession httpSession = request.getSession();
	int id = (int) httpSession.getAttribute("id");
	UserService userService = new UserService();
	UserDto user = userService.getById(id);
	%>
	<b><%=user.getUsername()%></b>
	<br>
	<br>
	<%
	ReportService reportService = new ReportService();
	List<ReportDetail> reportDetail = reportService.getAllReport();
	for (ReportDetail rd : reportDetail) {
		if (rd.getUserId() == id) {
	%>
	DATE :-
	<b><%=rd.getDate()%></b>

	<%
	if (rd.getSign_in() != null) {
	%>
	<br> SIGN IN:-
	<b><%=rd.getSign_in()%></b>
	<%
	}
	if (rd.getSign_out() != null) {
	%>

	<br> SIGN OUT:-
	<b><%=rd.getSign_out()%></b>
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
	%>
	<br>present
	<%
	}
	%>

	<br> ===================================

	<br>
	<%
	}
	}
	%>


	<br>
	<button type="button">
		<a href="UserView1.jsp">BACK</a>
	</button>

</body>
</html>