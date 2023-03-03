package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Vehicle;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class RentalCalculatorService {
    private Vehicle vehicle;
    public RentalCalculatorService(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public double calRental(LocalDateTime startRental, LocalDateTime endRental) throws Exception {
        if(startRental.isAfter(endRental)) {
            throw new Exception("start date not > end date");
        }

        long daysBetween = DAYS.between(startRental, endRental);
        double total = this.vehicle.getPrice() * daysBetween;

        return total;
    }
}
