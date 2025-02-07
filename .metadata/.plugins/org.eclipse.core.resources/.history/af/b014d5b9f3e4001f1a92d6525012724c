package com.tribleCarLeaseManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.tribleCarLeaseManagementSystem.dto.Car;
import com.tribleCarLeaseManagementSystem.repo.CarRepository;
import com.tribleCarLeaseManagementSystem.service.CarService;

public class CarServiceTest {
	 @Mock
	    private CarRepository carRepository;

	    @InjectMocks
	    private CarService carService;

	    private Car car;

	    @BeforeEach
	    void setUp() {
	        car = new Car();
	        car.setId(1L);
	        car.setModel("Toyota Corolla");
	    }

	    @Test
	    void registerCar_ShouldSaveCar() {
	        when(carRepository.save(car)).thenReturn(car);
	        Car savedCar = carService.registerCar(car);
	        assertNotNull(savedCar);
	        assertEquals("Toyota Corolla", savedCar.getModel());
	    }

	    @Test
	    void getCarStatus_ShouldReturnCar_WhenCarExists() {
	        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
	        Optional<Car> foundCar = carService.getCarStatus(1L);
	        assertTrue(foundCar.isPresent());
	        assertEquals("Toyota Corolla", foundCar.get().getModel());
	    }

	    @Test
	    void getAllCars_ShouldReturnListOfCars() {
	        when(carRepository.findAll()).thenReturn(Arrays.asList(car));
	        List<Car> cars = carService.getAllCars();
	        assertFalse(cars.isEmpty());
	        assertEquals(1, cars.size());
	    }
}
