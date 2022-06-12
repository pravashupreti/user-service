package com.ea.userservice.service;

import com.ea.userservice.payload.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {

	UserProfile loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

	UserProfile loadUserById(Long id);

}