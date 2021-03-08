package com.Diplom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.Diplom.entity.User;

public interface UserService { 

	public List<User> findAll();

	public User findByName(String name);

	public void createUser(User user);

	public boolean isUserPresent(String email);

	public void addResult(User user, boolean isTrue);

	public void saveUser(User user);

	public User registerNewGoogleUser(Map<String, Object> attributes);

	public Optional<User> findUserByEmail(String string);

	public User findByEmail(String name);

	public List<User> findByNameSearch(String name);

}
