package com.te.allerganlms.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public String getPassword() {
		return user.getEmployeePassword();
	}

	@Override
	public String getUsername() {
		return user.getEmployeeUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		if (user.getStatus().equals(UserStatus.ACTIVE)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAccountNonLocked() {
		if ((user.getStatus().equals(UserStatus.ACTIVE))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if ((user.getStatus().equals(UserStatus.ACTIVE))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isEnabled() {
		if ((user.getStatus().equals(UserStatus.ACTIVE))) {
			return true;
		} else {
			return false;
		}
	}

}
