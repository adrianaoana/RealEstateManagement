package com.squad.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.squad.utils.RequestUtil;

@Component
public class SecurityLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	        AuthenticationException exception) throws IOException, ServletException {
		System.out.println("failure handler-intro");
		// if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
		// System.out.println("f handler-xml");
		// response.getWriter().print("{success:false, message:'Username/Password are invalid'}");
		// response.getWriter().flush();
		// } else {
		// System.out.println("f handler-else");
		// super.onAuthenticationFailure(request, response, exception); //goes
		// on /login/failure
		// }
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		if (RequestUtil.isAjaxRequest(request)) {
			response.getWriter().print("{\"success\":false }");
			response.getWriter().flush();
		} else {
			// goes on /login/failure
			super.onAuthenticationFailure(request, response, exception); 
		}
	}

}