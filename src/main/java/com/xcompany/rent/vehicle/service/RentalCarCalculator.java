package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Driver;
import com.xcompany.rent.vehicle.entity.Vehicle;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

public class RentalCarCalculator extends RentalCalculatorService{
    private static final double MAX_PRICE = 7000;
    private static  final double RATIO = 0.2;
    private Driver driver;
    public RentalCarCalculator(Vehicle vehicle) {
        super(vehicle);
    }
    public RentalCarCalculator(Vehicle vehicle, Driver driver){
        super(vehicle);
        this.driver = driver;
    }

    public double calRentalWithDriver(LocalDateTime startRental, LocalDateTime endRental) throws Exception {
        double total = this.calRental(startRental, endRental);
        double priceWithDriver = this.driver.getPrice();

        Long hourDiff = HOURS.between(startRental, endRental);
        if (hourDiff > 0 && hourDiff < 9){
            priceWithDriver = priceWithDriver * hourDiff;
            total += priceWithDriver;

            return total;
        }
        else if(hourDiff >= 9 && hourDiff <= 12){
            priceWithDriver = priceWithDriver * hourDiff;
            double change = priceWithDriver * RATIO;
            priceWithDriver += change;
            total += priceWithDriver;

            return total;
        }
        else if(hourDiff > 12){
            long day = DAYS.between(startRental, endRental);
            priceWithDriver = MAX_PRICE * day;
            total += priceWithDriver;

            return total;
        }

        total += priceWithDriver;
        return total;
    }
}
