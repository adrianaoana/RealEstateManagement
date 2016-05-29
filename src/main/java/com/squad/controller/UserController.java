package com.squad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView userForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(USER_PROFILE_JSP);
		createMenu(request, modelAndView);
		modelAndView.addObject(USER, userService.getByEmail(request.getUserPrincipal().getName()));
		return modelAndView;

	}

	@RequestMapping(value = "user/settings", method = RequestMethod.GET)
	public ModelAndView userSettingsForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(USER_SETTINGS_JSP);
		modelAndView.addObject(USER, userService.getByEmail(request.getUserPrincipal().getName()));
		return modelAndView;

	}

	@RequestMapping(value = "user/settings", method = RequestMethod.POST)
	public ModelAndView userUpdate(@ModelAttribute @Validated User user, BindingResult bindingResult,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(USER_SETTINGS_JSP);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject(USER, user);
			return modelAndView;
		}
		userService.update(user);
		createMenu(request, modelAndView);
		modelAndView.addObject(USER, userService.getByEmail(request.getUserPrincipal().getName()));
		return modelAndView;

	}

	@RequestMapping(value = "user/change-password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer updatePassword(@RequestParam("password") String password, HttpServletRequest request) {
		userService.updatePassword(request.getUserPrincipal().getName(), password);
		return 0;
	}

}
