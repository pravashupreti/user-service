package com.ea.userservice.service;

import com.ea.userservice.model.user.User;
import com.ea.userservice.payload.*;


public interface UserService {

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username);

	ApiResponse deleteUser(String username);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo( String username , InfoRequest infoRequest);

}