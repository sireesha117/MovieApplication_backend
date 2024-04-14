package com.MovieApplication.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MovieApplication.demo.entity.User;
import com.MovieApplication.demo.repository.UserRepository;
import com.MovieApplication.demo.service.impl.UserServiceImpl;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addUserSuccess() {
        User user = new User();
        user.setUsername("admin");
        user.setPetname("dog");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");

        when(userRepository.save(any())).thenReturn(user);

        User savedUser = userService.addUser(user);
        assertEquals(user.getUsername(), savedUser.getUsername());
    }

    @Test
    public void addUserFailure() {
        when(userRepository.save(any())).thenReturn(null);

        User savedUser = userService.addUser(null);
        assertEquals(null, savedUser);
    }
}
