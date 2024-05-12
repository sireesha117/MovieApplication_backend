package com.MovieApplication.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieApplication.demo.entity.User;
import com.MovieApplication.demo.service.UserService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService uService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {

		List<User> userlist = uService.getAllUsers();

		if (userlist != null) {
			return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("userlist is empty", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findUser/{uid}")
	public ResponseEntity<?> findMovie(@PathVariable("uid") int uid) {
		return new ResponseEntity<User>(uService.getUserById(uid), HttpStatus.OK);
	}

}
