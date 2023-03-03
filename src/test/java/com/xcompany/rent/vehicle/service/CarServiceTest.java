package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.exception.NotFoundException;
import com.xcompany.rent.vehicle.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    private CarService carService;
    @Mock
    private CarRepository carRepository;

    @BeforeEach
    public void setup(){
        carService = new CarService(carRepository);
    }

    @Test
    public void shouldFindCarById() {
        Car newCar = new Car("test1", 10000);
        long id = 1;
        given(carRepository.findById(id)).willReturn(Optional.of(newCar));

        Car car = carService.findAllVehicleById(id);
        assertThat(car).isNotNull();
    }

    @Test
    public void ShouldFindcarNotFoundException() throws NotFoundException {
        long id = 2;
        Car car = new Car( "test",1000);
        given(carRepository.findById(id)).willReturn(Optional.ofNullable(null));

    }
}
