package com.xcompany.rent.vehicle.controller;


import com.xcompany.rent.vehicle.model.RequestRental;
import com.xcompany.rent.vehicle.service.RentalCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private RentalCarService rentalCarService;
    public RentalController(RentalCarService rentalCarService){
        this.rentalCarService = rentalCarService;
    }
    @GetMapping
    public ResponseEntity getRentalAll() {
        var listRent = this.rentalCarService.getAllRental();
        return ResponseEntity.status(HttpStatus.OK).body(listRent);
    }

    @PostMapping
    public ResponseEntity createRental(@Valid @RequestBody RequestRental rentalCar){
        var rent = this.rentalCarService.createRental(rentalCar);
        return ResponseEntity.status(HttpStatus.OK).body(rent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity cancelRental(@PathVariable("id") long id, @RequestBody @Valid RequestRental requestRental){
       var updated = this.rentalCarService.updateRental(id, requestRental);
       return  ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRental(@PathVariable long id){
        this.rentalCarService.deleteRental(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("deleted");
    }
}
