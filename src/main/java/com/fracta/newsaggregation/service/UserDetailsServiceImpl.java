package com.fracta.newsaggregation.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fracta.newsaggregation.repo.UserRepo;

import com.fracta.newsaggregation.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepo userRepo;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
				String.format("%s username not found.", username)));
		
		return new org.springframework.security.core.userdetails.
				User(username, user.getPassword(), user.isEnabled(), true, true, true, getAuthorities("USER")); 
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}
}
