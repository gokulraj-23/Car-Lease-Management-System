package com.tribleCarLeaseManagementSystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import com.tribleCarLeaseManagementSystem.repo.UserRepository;

public class UserService {
	 @Autowired
	    private UserRepository userRepository;
	    
	    // Registers a new user in the system
	    public User registerUser(User user) {
	        return userRepository.save(user);
	    }
	    
	    // Retrieves a list of all registered users
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
}
