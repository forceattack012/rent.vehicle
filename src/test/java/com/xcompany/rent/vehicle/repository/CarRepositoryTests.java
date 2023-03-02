package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CarRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CarRepository carRepository;

    @Test
    public void WhenCreatedCarShouldGetId(){
        Car car = new Car();
        car.setPrice(1000);
        car.setName("test");
        var newCar = carRepository.save(car);

        assertNotNull(newCar.getId());
    }

    @Test
    public void shouldFindCarById(){
        Car newCar = new Car("m", 1000);
        entityManager.persist(newCar);

        Car newCar2 = new Car("a", 200);
        entityManager.persist(newCar2);

        Car car = carRepository.findById(newCar.getId()).get();
        assertEquals(newCar.getName(), car.getName());
        assertEquals(newCar.getPrice(), car.getPrice());
    }
}
