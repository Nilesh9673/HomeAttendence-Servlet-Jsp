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

@WebServlet("/savereport")
public class SaveReport extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		httpSession.getAttribute("id");
		int rid = (int) httpSession.getAttribute("rid");
		ReportService reportService = new ReportService();
		ReportDetail reportDetail = reportService.getReportById(rid);
		int flag = (int) httpSession.getAttribute("flag");
		if (flag == 0 && reportDetail.getSign_in() == null) {

			reportService.updateSignIn(rid, LocalTime.now());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserView1.jsp");
			requestDispatcher.forward(req, resp);
		} else if (reportDetail.getSign_out() == null) {
			reportService.updateSignOut(rid, LocalTime.now());

			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<a href='userLogout'> LOGOUT</a>");
		}
	}
}
