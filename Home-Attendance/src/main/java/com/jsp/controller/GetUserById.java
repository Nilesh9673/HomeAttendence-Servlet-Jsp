package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.UserDto;
import com.jsp.service.UserService;

@WebServlet("/getuserbyid")
public class GetUserById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("number"));

		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("uid", id);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminView2.jsp");
		requestDispatcher.forward(req, resp);

	}

}
