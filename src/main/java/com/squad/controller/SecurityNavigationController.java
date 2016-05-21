package com.squad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.squad.model.User;

@Controller
@RequestMapping("/")
public class SecurityNavigationController extends MainController {

	public static final String USER_PROFILE_JSP = "userProfile";
	public static final String USERNAME = "username";

	@RequestMapping(value = "default", method = RequestMethod.GET)
	public ModelAndView defaultAfterLogin(HttpServletRequest request) {
		request.getSession().setAttribute(USERNAME, request.getUserPrincipal().getName());
		return new ModelAndView(USER_PROFILE_JSP).addObject(USER, new User());
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView(INDEX_JSP);
	}

	@RequestMapping(value = "login/failure", method = RequestMethod.GET)
	public ModelAndView loginFailure(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(INDEX_JSP);
		return modelAndView;

	}

	@RequestMapping(value = { "logout" }, method = RequestMethod.GET)
	public String successLogut(HttpServletRequest request) {
		return "redirect:/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(INDEX_JSP);
		createMenu(request, modelAndView);
		return modelAndView;
	}

}