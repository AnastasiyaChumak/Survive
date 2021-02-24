package com.Diplom.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.Diplom.dto.UserDto;
import com.Diplom.entity.Answer;
import com.Diplom.entity.Role;
import com.Diplom.entity.User;
import com.Diplom.repositories.AnswerRepository;
import com.Diplom.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Integer CORRECT_RESULT_POINTS = 10;

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setPassword("1111");
		user.setRole(Role.USER);
		user.setResult(10);
		userRepository.save(user);
	}

	@Override
	public boolean isUserPresent(String email) {
		return false;
	}

	/*
	 * public void createAdmin(User user) { BCryptPasswordEncoder encoder = new
	 * BCryptPasswordEncoder();
	 * user.setPassword(encoder.encode(user.getPassword()));
	 * user.setRole(Role.ADMIN); userRepository.save(user); }
	 */

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User findByEmail(String name) {
		return userRepository.findUserByEmail(name);
	}

	public void saveUser(User user) throws ValidationException {
		userRepository.save(user);
	}

	@Override
	public void addResult(User user, boolean isTrue) {
		if (isTrue) {
			user.setResult(user.getResult() + CORRECT_RESULT_POINTS);
			saveUser(user);
		}
	}

	public User registerNewGoogleUser(Map<String, Object> attributes) {
		User newUser = new User();
		newUser.setName((String) attributes.get("given_name"));
		newUser.setEmail((String) attributes.get("email"));
		newUser.setPassword("1111");
		newUser.setRole(Role.USER);
		newUser.setResult(0);
		return userRepository.save(newUser);

	}

	@Override
	public Optional<User> findUserByEmail(String string) {
		return userRepository.findByEmail(string);
	}
	

}