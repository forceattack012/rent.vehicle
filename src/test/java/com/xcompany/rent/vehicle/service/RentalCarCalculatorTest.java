package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.entity.Driver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RentalCarCalculatorTest {
    @Test
    public void shouldCalculateRentCarOneDay() throws Exception {
        Car car = new Car("test", 1000.25, true);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car);
        var today = LocalDateTime.now();
        var nextOneDay = LocalDateTime.now().plusDays(1);
        double total = rentalCarCalculator.calRental(today, nextOneDay);

        assertEquals(1000.25, total);
    }

    @Test
    public void shouldCalculateRentCarOneHour() throws Exception {
        Car car = new Car("test", 1000.25, true);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car);
        var today = LocalDateTime.now();
        var nextFiveDay = today.plusHours(1);
        double total = rentalCarCalculator.calRental(today, nextFiveDay);

        assertEquals(1000.25, total);
    }

    @Test
    public void shouldCalculateRentCarSameDay() throws Exception {
        Car car = new Car("test", 1000.25, true);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car);
        var today = LocalDateTime.now();
        var next = today;
        double total = rentalCarCalculator.calRental(today, next);

        assertEquals(1000.25, total);
    }

    @Test
    public void shouldCalculateRentCarFiveDay() throws Exception {
        Car car = new Car("test", 1000.25, true);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car);
        var today = LocalDateTime.now();
        var nextFiveDay = LocalDateTime.now().plusDays(5);
        double total = rentalCarCalculator.calRental(today, nextFiveDay);

        assertEquals(5001.25, total);
    }

    @Test
    public void shouldCalculateRentCarWithDriver() throws Exception {
        Car car = new Car("test", 100, true);
        Driver driver = new Driver(1, "123", LocalDate.now().plusDays(3), 200.00, true, 1);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car, driver);
        double total = rentalCarCalculator.calRentalWithDriver(LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        assertTrue(driver.getIsValid());
        assertEquals(500, total);
    }

    @Test
    public void shouldCalculateRentCarWithDriverAnHour() throws Exception {
        Car car = new Car("test", 100, true);
        Driver driver = new Driver(1, "123", LocalDate.now().plusDays(3), 200.00, true, 1);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car, driver);
        double total = rentalCarCalculator.calRentalWithDriver(LocalDateTime.now(), LocalDateTime.now());

        assertTrue(driver.getIsValid());
        assertEquals(300, total);
    }

    @Test
    public void shouldCalculateRentCarWithDriverOverEightHours() throws Exception {
        Car car = new Car("test", 100, true);
        Driver driver = new Driver(1, "123", LocalDate.now().minusDays(2), 200.00, true, 1);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car, driver);
        var today = LocalDateTime.now();
        double total = rentalCarCalculator.calRentalWithDriver(today, today.plusHours(10));

        assertFalse(driver.getIsValid());
        assertEquals(2500, total);
    }

    @Test
    public void shouldCalculateRentCarWithDriverTwoDaysAndOverTwevelHours() throws Exception {
        Car car = new Car("test", 200, true);
        Driver driver = new Driver(1, "123", LocalDate.now().minusDays(2), 500.00, true, 1);
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator(car, driver);
        var today = LocalDateTime.now();
        var nextTwoDay = LocalDateTime.now().plusDays(2);
        double total = rentalCarCalculator.calRentalWithDriver(today, nextTwoDay);

        assertFalse(driver.getIsValid());
        assertEquals(14400, total);
    }
}
