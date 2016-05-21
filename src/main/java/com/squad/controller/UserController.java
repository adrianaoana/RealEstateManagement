package com.squad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad.model.User;
import com.squad.utils.RequestUtil;

@Controller
@RequestMapping("/")
public class UserController extends MainController {

	@Autowired
	@Qualifier("userValidator")
	private Validator userValidator;

	@InitBinder(USER)
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	private static final String USERNAME = "username";

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void add(@ModelAttribute(USER) @Validated User user, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (RequestUtil.isAjaxRequest(request)) {
				response.setContentType("application/json;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");

				if (!bindingResult.hasErrors()) {
					int errorCode = userService.add(user);
					if (errorCode == 0) {
						response.getWriter().print("{\"success\":true,\"targetUrl\": \"\"}");
						response.getWriter().flush();
					} else {
						response.getWriter().print("{\"success\":false,\"errors\": \""
								+ "This email address is already registered!" + "\"}");
						response.getWriter().flush();
					}

				} else {
					String errorInfo = "";
					for (FieldError field : bindingResult.getFieldErrors()) {
						errorInfo = errorInfo + field.getDefaultMessage() + "<br/>";
					}
					response.getWriter().print("{\"success\":false,\"errors\": \"" + errorInfo + "\"}");
					response.getWriter().flush();
				}
			} else {
				RequestUtil.sendJsonResponse(response, "error", "error");
			}
		} catch (IOException e) {
		}
	}

	@RequestMapping(value = "user/remove", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value = USERNAME) String email, HttpServletRequest request) {
		userService.delete(email);
		return new ModelAndView("redirect:/");
	}
}
