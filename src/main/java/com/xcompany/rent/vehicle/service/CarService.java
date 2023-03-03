package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.exception.NotFoundException;
import com.xcompany.rent.vehicle.repository.CarRepository;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements VehicleService<Car>{
    private final CarRepository carRepository;
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    @Override
    public List<Car> findAllVehicle() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findAllVehicleById(long id) throws Exception {
        var car = this.carRepository.findById(id).orElse(new Car());
        if(car.getId() == 0){
            return car;
        }
        RentalCalculatorService rentalCar = new RentalCarCalculator(car);
        var total = rentalCar.calRental(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        return car;
    }

}
