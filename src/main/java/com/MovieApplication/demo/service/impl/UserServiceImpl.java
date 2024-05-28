package com.MovieApplication.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.User;
import com.MovieApplication.demo.repository.UserRepository;
import com.MovieApplication.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {
		if (user != null) {
			return userRepo.save(user);

		}
		return null;
	}

	@Override
	public boolean loginUser(String username, String password, String userRole) {

		User user1 = userRepo.validateUser(username, password, userRole);

		if (user1 != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> userList = userRepo.findAll();

		if (userList != null & userList.size() > 0) {
			return userList;
		} else
			return null;
	}

	@Override
	public User getUserById(int uid) {
		Optional<User> user = userRepo.findById(uid);
		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}

	@Override
	public int forgotPassword(String username, String petname) {

		try {
			User user2 = userRepo.RequestValue(username, petname);
			return user2.getId();
		} catch (Exception e) {
			System.out.println(-1);
			return -1;
		}
	}
	@Override
    public User updateUser(int uid, User user) {
        Optional<User> existingUser = userRepo.findById(uid);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setUserRole(user.getUserRole());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPetname(user.getPetname());
            return userRepo.save(updatedUser);
        }
        return null;
    }
	

}
