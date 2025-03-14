package com.tribleCarLeaseManagementSystem.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.tribleCarLeaseManagementSystem.dto.Car;
import com.tribleCarLeaseManagementSystem.repo.CarRepository;

public class CarService {
	  
	 @Autowired
	    private CarRepository carRepository;
	    
	    // Registers a new car in the database
	    public Car registerCar(Car car) {
	        return carRepository.save(car);
	    }
	    
	    // Retrieves the status of a car based on its ID
	    public Optional<Car> getCarStatus(Long id) {
	        return carRepository.findById(id);
	    }
	    
	    // Fetches the lease history of a car using its ID
	    public List<Car> getLeaseHistory(Long id) {
	        return carRepository.findLeaseHistoryByCarId(id);
	    }
	    
	    // Retrieves all registered cars
	    public List<Car> getAllCars() {
	        return carRepository.findAll();
	    }
	  
  
}

