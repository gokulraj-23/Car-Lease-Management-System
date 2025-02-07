package com.tribleCarLeaseManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.tribleCarLeaseManagementSystem.repo.UserRepository;
import com.tribleCarLeaseManagementSystem.service.UserService;

public class UserServiceTest {
	 @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserService userService;

	    private User user;

	    @BeforeEach
	    void setUp() {
	        user = new User();
	        user.setId(1L);
	        user.setName("John Doe"); // Create a sample user instance
	    }

	    @Test
	    void registerUser_ShouldSaveUser() {
	        when(userRepository.save(user)).thenReturn(user);
	        User savedUser = userService.registerUser(user);
	        assertNotNull(savedUser); // Ensure the saved user is not null
	        assertEquals("John Doe", savedUser.getName()); // Validate user name
	    }

	    @Test
	    void getAllUsers_ShouldReturnListOfUsers() {
	        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
	        List<User> users = userService.getAllUsers();
	        assertFalse(users.isEmpty()); // Ensure the list is not empty
	        assertEquals(1, users.size()); // Validate list size
	    }
}
