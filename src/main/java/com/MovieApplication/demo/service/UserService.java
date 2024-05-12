package com.MovieApplication.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.User;

@Service
public interface UserService {
	public User addUser(User user);// user registration

	public boolean loginUser(String username, String password, String userRole);// login

	public User getUserById(int uid);

	public int forgotPassword(String username, String petname);

	public List<User> getAllUsers();// will be visible only if you are logged in

}
