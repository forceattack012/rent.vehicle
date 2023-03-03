package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenCreatedCarShouldGetId(){
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

    @Test
    public void shouldDeleteCarById(){
        entityManager.persist(new Car("test", 200));
        entityManager.persist(new Car("test2", 20001));
        long id = 1L;

        carRepository.deleteById(id);
        var car = carRepository.findById(id);

        assertTrue(car.isEmpty());
    }
}
