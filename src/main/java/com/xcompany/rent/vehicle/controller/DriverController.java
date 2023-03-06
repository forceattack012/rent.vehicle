package com.xcompany.rent.vehicle.controller;

import com.xcompany.rent.vehicle.entity.Driver;
import com.xcompany.rent.vehicle.model.RequestDriver;
import com.xcompany.rent.vehicle.service.PersonService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private PersonService<Driver> driverService;
    public DriverController(PersonService<Driver> driverService){
        this.driverService = driverService;
    }
    @PostMapping
    public ResponseEntity createDriver(@RequestBody @Valid RequestDriver reqDriver){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        var driver = modelMapper.map(reqDriver, Driver.class);
        var createdDriver = this.driverService.create(driver);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdDriver);
    }

    @GetMapping
    public ResponseEntity getAllDriver(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        var drivers = this.driverService.getAll(Driver.class, page, pageSize, "rating");
        return ResponseEntity.status(HttpStatus.OK).body(drivers);
    }
}
