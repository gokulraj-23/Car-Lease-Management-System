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
    private CarRepository carRepository; // Mock the CarRepository dependency

    @InjectMocks
    private CarService carService; // Inject the mocked repository into CarService

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
        car.setId(1L);
        car.setModel("Toyota Corolla"); // Set up a sample car instance
    }

    @Test
    void registerCar_ShouldSaveCar() {
        when(carRepository.save(car)).thenReturn(car);
        Car savedCar = carService.registerCar(car);
        assertNotNull(savedCar); // Ensure the saved car is not null
        assertEquals("Toyota Corolla", savedCar.getModel()); // Validate car model
    }

    @Test
    void getCarStatus_ShouldReturnCar_WhenCarExists() {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        Optional<Car> foundCar = carService.getCarStatus(1L);
        assertTrue(foundCar.isPresent()); // Ensure car is found
        assertEquals("Toyota Corolla", foundCar.get().getModel());
    }

    @Test
    void getAllCars_ShouldReturnListOfCars() {
        when(carRepository.findAll()).thenReturn(Arrays.asList(car));
        List<Car> cars = carService.getAllCars();
        assertFalse(cars.isEmpty()); // Ensure the car list is not empty
        assertEquals(1, cars.size()); // Validate list size
    }
}
