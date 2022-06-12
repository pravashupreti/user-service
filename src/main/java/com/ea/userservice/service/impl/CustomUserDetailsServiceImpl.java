package com.ea.userservice.service.impl;

import com.ea.userservice.model.user.User;
import com.ea.userservice.payload.UserProfile;
import com.ea.userservice.repository.UserRepository;

import com.ea.userservice.service.CustomUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsServiceImpl implements
         CustomUserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Transactional
    public UserProfile loadUserByUsername(String usernameOrEmail) {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with this username or email: %s", usernameOrEmail)));

        UserProfile userProfile = new UserProfile();

        modelMapper.map(user, userProfile);
        return userProfile;
    }

    @Override
    @Transactional
    public UserProfile loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with id: %s", id)));

        UserProfile userProfile = new UserProfile();

        modelMapper.map(user, userProfile);
        return userProfile;
    }
}
