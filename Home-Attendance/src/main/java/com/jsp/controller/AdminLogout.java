package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		if (httpSession != null) {
			httpSession.removeAttribute("uid");

			httpSession.invalidate();
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body>SUCCESFULLY LOGOUT</body></html>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserLogin.jsp");
		requestDispatcher.include(req, resp);

	}

}
