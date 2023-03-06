package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RentalCarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private RentalCarRepository rentalCarRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldCreateCarRental() {
        Car car = new Car("rs", 10000, true);

        Customer customer = new Customer();
        customer.setLastName("assss");
        customer.setName("ssss");
        customer.setCitizenId("111111");
        customer.setBirthDate(LocalDate.now());

        RentalCar rentalCar = new RentalCar();
        rentalCar.setStartDate(LocalDateTime.now());
        rentalCar.setEndDate(LocalDateTime.now().plusDays(1));
        rentalCar.setCar(car);
        rentalCar.setCustomer(customer);
        rentalCar.setTotalAmount(1000.00);

        this.rentalCarRepository.save(rentalCar);
    }
}
