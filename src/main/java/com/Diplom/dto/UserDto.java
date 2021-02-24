package com.Diplom.dto;

import java.util.Map;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	private String email;
	private String name;
	@Size(min = 4)
	private String password;
	private String matchingPassword;
	
	  private Map<String, Object> attributes;

	    public UserDto(Map<String, Object> attributes) {
	        this.attributes = attributes;
	    }
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	

}
