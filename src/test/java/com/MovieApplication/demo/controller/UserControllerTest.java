package com.MovieApplication.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.MovieApplication.demo.entity.User;
import com.MovieApplication.demo.service.impl.UserServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

	@Mock
	private UserServiceImpl userService;

	@InjectMocks
	private UserController userC;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userC).build();
	}

	List<User> userList = new ArrayList<User>();

	@Test
	public void getAllUsersSuccess() throws Exception {
		User user = new User();

		user.setUsername("admin");
		user.setPetname("dog");
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");

		userList.add(user);
		when(userService.getAllUsers()).thenReturn(userList);

		List<User> uList = userService.getAllUsers();
		assertEquals(userList, uList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllUsers").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}