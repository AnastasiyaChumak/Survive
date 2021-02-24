package com.Diplom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Diplom.entity.Answer;
import com.Diplom.entity.User;
import com.Diplom.repositories.RoleRepository;
import com.Diplom.repositories.UserRepository;


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


}
