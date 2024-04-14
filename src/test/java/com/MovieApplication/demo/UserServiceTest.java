package com.MovieApplication.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MovieApplication.demo.entity.User;
import com.MovieApplication.demo.repository.UserRepository;
import com.MovieApplication.demo.service.impl.UserServiceImpl;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllUsersSuccess() {
        User user = new User();
        user.setUsername("admin");
        user.setPetname("dog");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");

        List<User> userList = new ArrayList<>();
        userList.add(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> returnedUserList = userService.getAllUsers();
        assertEquals(userList, returnedUserList);
    }
}
