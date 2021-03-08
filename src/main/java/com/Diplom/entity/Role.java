package com.Diplom.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	USER, ADMIN, MARK;

	@Override
	public String getAuthority() {
		return name();
	}
}