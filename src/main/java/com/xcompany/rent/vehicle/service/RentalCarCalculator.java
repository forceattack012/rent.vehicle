package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Vehicle;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class RentalCarCalculator extends RentalCalculatorService{
    public RentalCarCalculator(Vehicle vehicle) {
        super(vehicle);
    }
}
