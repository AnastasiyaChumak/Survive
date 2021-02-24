package com.Diplom.services;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.User;
import com.Diplom.repositories.LogUserRepository;

@Component("oauth2authSuccessHandler")
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public static final String REDIRECT_URL_SESSION_ATTRIBUTE_NAME = "REDIRECT_URL";

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private UserService userService;

	@Autowired
	private LogUserService logService;
	
	@Autowired
	private LogUserRepository repo;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) authentication;
		Map<String, Object> attributes = authenticationToken.getPrincipal().getAttributes();
		Optional<User> userOptional = userService.findUserByEmail((String) attributes.get("email"));
		logService.saveUser(attributes);
		LogUser us = repo.findById(1);
		us.setEmail((String) attributes.get("email"));
		repo.save(us);
		User user = null;
		if (!userOptional.isPresent()) {
			user = userService.registerNewGoogleUser(attributes);
		} else {
			user = userOptional.get();
			logService.saveUser(attributes);
			userService.saveUser(user);
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Object redirectURLObject = request.getSession().getAttribute(REDIRECT_URL_SESSION_ATTRIBUTE_NAME);
		String url = "/";
		if (redirectURLObject != null) {
			url = redirectURLObject.toString();
		}
		request.setAttribute("message", "some message");
		request.getSession().removeAttribute(REDIRECT_URL_SESSION_ATTRIBUTE_NAME);
		redirectStrategy.sendRedirect(request, response, "/index");
	}
}