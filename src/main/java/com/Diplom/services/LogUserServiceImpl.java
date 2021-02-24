package com.Diplom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.Role;
import com.Diplom.entity.User;
import com.Diplom.repositories.LogUserRepository;

@Service
@Transactional
public class LogUserServiceImpl implements LogUserService {

	@Autowired
	LogUserRepository repo;

	@Override
	public LogUser findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<LogUser> findAll() {
		return repo.findAll();
	}

	@Override
	public LogUser saveUser(Map<String, Object> attributes) {
		LogUser newUser = new LogUser();
		newUser.setEmail((String) attributes.get("email"));
		newUser.setId(1);
		return repo.save(newUser);
	}
	
	public void saveLogUser(LogUser user) throws ValidationException {
		repo.save(user);
	}
	
	public void deleteLogUser() throws ValidationException {
		repo.deleteAll();
	}
	
	@Override
	public Optional<LogUser> findUserByEmail(String string) {
		return repo.findByEmail(string);
	}
}
