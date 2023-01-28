package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.ReportDetail;
import com.jsp.service.ReportService;

@WebServlet("/userLogout")
public class UserLogout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		httpSession.removeAttribute("flag");
		httpSession.removeAttribute("id");
		httpSession.removeAttribute("rid");

		httpSession.invalidate();

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + "Logout Successfully" + "</h1>" + "<br><br>" + "</body></html>");
		printWriter.print("<br>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserLogin.jsp");
		requestDispatcher.include(req, resp);

	}

}
