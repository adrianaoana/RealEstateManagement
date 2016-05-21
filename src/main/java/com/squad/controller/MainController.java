package com.squad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.squad.model.User;
import com.squad.service.UserService;

@Controller
public class MainController {

	@Autowired
	protected UserService userService;

	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String MESSAGE = "message";
	public static final String USER = "user";

	/* PAGES */
	public static final String INDEX_JSP = "index";

	public void createMenu(HttpServletRequest request, ModelAndView modelAndView) {
		if (request.getSession().getAttribute(USER) == null) {
			request.getSession().setAttribute(USER, new User());
		}
		modelAndView.addObject(USER, request.getSession().getAttribute(USER));
	}
}
