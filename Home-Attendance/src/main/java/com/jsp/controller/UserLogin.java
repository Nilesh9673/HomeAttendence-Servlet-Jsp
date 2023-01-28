package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.ReportDetail;
import com.jsp.dto.UserDto;
import com.jsp.service.ReportService;
import com.jsp.service.UserService;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter printWriter = resp.getWriter();

		UserService userService = new UserService();
		List<UserDto> user = userService.getAllUser();
		for (UserDto u : user) {

			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				int id = u.getId();

				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("id", id);

				ReportDetail reportDetail = new ReportDetail();
				reportDetail.setDate(LocalDate.now());
				reportDetail.setUserId(id);

				ReportService reportService = new ReportService();
				reportService.saveReport(reportDetail);

				httpSession.setAttribute("rid", reportDetail.getId());

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserView1.jsp");
				requestDispatcher.forward(req, resp);

			}
		}

		if (username.equals("root") && password.equals("root")) {

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminView1.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			printWriter.print("<html><body><h1></h1>" + "Invalid credentials" + "</h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserLogin.jsp");
			requestDispatcher.include(req, resp);
		}

		/* printWriter.print("<a href='SaveUser.jsp'>home<a/>"); */

	}

}
