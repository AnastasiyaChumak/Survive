package com.Diplom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.User;

@Service
public interface LogUserService { 
	
	public List<LogUser> findAll();
	
	public LogUser findById(int id);
	
	public LogUser saveUser(Map<String, Object> attributes);
	
	public void saveLogUser(LogUser user);
	
	public void deleteLogUser();
	
	public Optional<LogUser> findUserByEmail(String string);
}
