package com.squad.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.squad.utils.RequestUtil;

@Component
public class SecurityLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	// public SecurityLoginSuccessHandler() {
	// super();
	// }
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		System.out.println("succes handler intro");
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		if (RequestUtil.isAjaxRequest(request)) {
			response.getWriter().print("{\"success\":true,\"targetUrl\": \"" + this.getDefaultTargetUrl() + "\"}");
			response.getWriter().flush();
		} else {
			super.onAuthenticationSuccess(request, response, auth);
		}
	}
}