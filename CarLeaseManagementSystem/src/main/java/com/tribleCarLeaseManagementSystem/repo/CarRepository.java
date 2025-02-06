package com.tribleCarLeaseManagementSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tribleCarLeaseManagementSystem.dto.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	// Custom method to find lease history of a car by its ID
    List<Car> findLeaseHistoryByCarId(Long id);
}
