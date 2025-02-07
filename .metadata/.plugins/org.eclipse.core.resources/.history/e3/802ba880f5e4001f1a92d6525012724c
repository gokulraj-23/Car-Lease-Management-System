package com.tribleCarLeaseManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tribleCarLeaseManagementSystem.dto.Car;
import com.tribleCarLeaseManagementSystem.repo.CarRepository;

public class CarService {
	  
	  @Autowired
	    private CarRepository carRepository;
	    
	    public Car registerCar(Car car) {
	        return carRepository.save(car);
	    }
	    
	    public Optional<Car> getCarStatus(Long id) {
	        return carRepository.findById(id);
	    }
	    
	    public List<Car> getLeaseHistory(Long id) {
	        return carRepository.findLeaseHistoryByCarId(id);
	    }
	    
	    public List<Car> getAllCars() {
	        return carRepository.findAll();
	    }
	  
  
}

