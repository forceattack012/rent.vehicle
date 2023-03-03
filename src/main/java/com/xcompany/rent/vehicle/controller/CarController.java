package com.xcompany.rent.vehicle.controller;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/car")
    public ResponseEntity GetCars(){
        List<Car> cars = this.carService.findAllVehicle();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
    @GetMapping("/car/{id}")
    public ResponseEntity GetCarById(@PathVariable("id") long id){
        Car car = this.carService.findAllVehicleById(id);
        if(car.getId() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(car);
    }
}
