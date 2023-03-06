package com.xcompany.rent.vehicle.controller;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.model.RequestSearchCar;
import com.xcompany.rent.vehicle.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity getCars(@RequestParam(required = false, name = "page") int page, @RequestParam("pageSize") int pageSize){
        var cars = this.carService.findAllVehicle(page, pageSize).stream().toList();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
    @PostMapping
    public ResponseEntity createCar(@RequestBody Car car){
       long id = this.carService.createVehicle(car);
       return ResponseEntity.status(HttpStatus.OK).body(id);
    }
    @PatchMapping("/{id}")
    public ResponseEntity updateCarById(@PathVariable long id, @RequestBody Car car){
        var updtedCar = this.carService.updateVehicle(id, car);
        return ResponseEntity.status(HttpStatus.OK).body(updtedCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable("id") long id) throws Exception {
        Car car = this.carService.findAllVehicleById(id);
        if(car.getId() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PostMapping("/search")
    public ResponseEntity getAllCarsAreEmptyByDate(@Valid @RequestBody RequestSearchCar requestSearchCar) throws Exception {
        var cars = this.carService.findAllVehicleIsEmptyByDate(requestSearchCar.getStartDate(), requestSearchCar.getEndDate());
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
}
