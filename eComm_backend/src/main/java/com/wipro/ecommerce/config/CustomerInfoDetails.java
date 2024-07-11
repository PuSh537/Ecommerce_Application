package com.wipro.ecommerce.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wipro.ecommerce.entity.Customer;

public class CustomerInfoDetails implements UserDetails {
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	public CustomerInfoDetails(Customer customer) {
		name = customer.getUsername();
		password = customer.getPassword();
		authorities = Arrays.stream(customer.getRole().split(",")).map(SimpleGrantedAuthority::new) // .map(str -> new
																									// SimpleGrantedAuthority(str))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
//	@Getter(AccessLevel.NONE)
//	@OneToOne(mappedBy = "customer")
//	private Permission permission;

}
