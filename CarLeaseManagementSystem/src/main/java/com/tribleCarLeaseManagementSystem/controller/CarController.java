package com.tribleCarLeaseManagementSystem.controller;

import java.rmi.dgc.Lease;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tribleCarLeaseManagementSystem.dto.Car;
import com.tribleCarLeaseManagementSystem.exception.ResourceNotFoundException;
import com.tribleCarLeaseManagementSystem.service.CarService;
import com.tribleCarLeaseManagementSystem.service.LeaseService;
import com.tribleCarLeaseManagementSystem.service.UserService;

public class CarController {

	
	  @Autowired
	    private CarService carService;
	    
	    @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private LeaseService leaseService;
	    
	    // register a new car
	    @PostMapping("/cars/register")
	    public Car registerCar(@RequestBody Car car) {
	        return carService.registerCar(car);
	    }
	    
	    // get the status of a car by ID
	    @GetMapping("/cars/status/{id}")
	    public Car getCarStatus(@PathVariable Long id) {
	        return carService.getCarStatus(id).orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
	    }
	    
	    // get the lease history of a specific car
	    @GetMapping("/cars/history/{id}")
	    public List<Car> getLeaseHistory(@PathVariable Long id) {
	        return carService.getLeaseHistory(id);
	    }
	    
	    // register a user (Car Owner or End Customer)
	    @PostMapping("/users/register")
	    public User registerUser(@RequestBody User user) {
	        return userService.registerUser(user);
	    }
	    
	    // start a car lease
	    @PostMapping("/lease/start")
	    public Lease startLease(@RequestBody Lease lease) {
	        return leaseService.startLease(lease);
	    }
	    
	    // End point to end a car lease
	    @PostMapping("/lease/end/{id}")
	    public Lease endLease(@PathVariable Long id) {
	        return leaseService.endLease(id);
	    }
	    
	    // End point for admin to fetch all users
	    @GetMapping("/admin/users")
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }
	    
	    // End point for admin to fetch all cars
	    @GetMapping("/admin/cars")
	    public List<Car> getAllCars() {
	        return carService.getAllCars();
	    }
	}
