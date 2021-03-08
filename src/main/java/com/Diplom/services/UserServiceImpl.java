package com.Diplom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Diplom.entity.Role;
import com.Diplom.entity.User;
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
	
	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<User> findByNameSearch(String name) {
		return userRepository.findByNameLike("%" + name + "%");
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
		newUser.setRole(Role.ADMIN);
		newUser.setResult(0);
		return userRepository.save(newUser);

	}

	@Override
	public Optional<User> findUserByEmail(String string) {
		return userRepository.findByEmail(string);
	}

}