package com.wipro.ecommerce.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wipro.ecommerce.entity.Admin;

public class AdminInfoDetails implements UserDetails {
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	public AdminInfoDetails(Admin admin) {
		name = admin.getUsername();
		password = admin.getPassword();
		authorities = Arrays.stream(admin.getRole().split(",")).map(SimpleGrantedAuthority::new) // .map(str -> new
																									// SimpleGrantedAuthority(str))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
