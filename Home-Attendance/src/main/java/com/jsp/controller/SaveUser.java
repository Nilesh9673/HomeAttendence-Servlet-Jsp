package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.UserDto;
import com.jsp.service.UserService;

@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String cno = req.getParameter("number");
		PrintWriter printWriter = resp.getWriter();

		if (!(username.isEmpty() || password.isEmpty() || email.isEmpty() || cno.isEmpty())) {
			UserService userService = new UserService();
			List<UserDto> users = userService.getAllUser();
			for (UserDto u : users) {
				if ((u.getUsername().equals(username) || u.getEmail().equals(email) || u.getCno().equals(cno))) {
					printWriter.print("<html><body><h1></h1>" + "User Already exist" + "</h1></body></html>");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("SaveUser.jsp");
					requestDispatcher.include(req, resp);
					return;
				}
			}
			UserDto userDto = new UserDto();
			userDto.setUsername(username);
			userDto.setPassword(password);
			userDto.setEmail(email);
			userDto.setCno(cno);

			userService.saveUser(userDto);

			printWriter.print("<html><body><h1></h1>" + "User saved succesfully" + "</h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("SaveUser.jsp");
			requestDispatcher.include(req, resp);

		} else {
			printWriter.print("<html><body><h1></h1>" + "Enter all the details" + "</h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("SaveUser.jsp");
			requestDispatcher.include(req, resp);

		}

	}
}
