package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Vehicle;
import org.hibernate.service.NullServiceException;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class RentalCalculatorService {
    private Vehicle vehicle;
    public RentalCalculatorService(Vehicle vehicle){
        if(vehicle == null) {
            throw new NullServiceException(Vehicle.class);
        }
        this.vehicle = vehicle;
    }

    public double calRental(LocalDateTime startRental, LocalDateTime endRental) throws Exception {
        if(startRental == null || endRental == null){
            throw  new NullPointerException("startRental or endRental is null");
        }
        if(startRental.isAfter(endRental)) {
            throw new Exception("start date not > end date");
        }

        long daysBetween = DAYS.between(startRental, endRental);
        if(daysBetween == 0){
            return this.vehicle.getPrice();
        }

        return this.vehicle.getPrice() * daysBetween;
    }

    public double calRental(OffsetDateTime startRental, OffsetDateTime endRental) throws Exception {
        if(startRental == null || endRental == null){
            throw  new NullPointerException("startRental or endRental is null");
        }
        if(startRental.isAfter(endRental)) {
            throw new Exception("start date not > end date");
        }

        long daysBetween = DAYS.between(startRental, endRental);
        if(daysBetween == 0){
            return this.vehicle.getPrice();
        }

        return this.vehicle.getPrice() * daysBetween;
    }
}
