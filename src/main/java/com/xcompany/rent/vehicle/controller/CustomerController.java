package com.xcompany.rent.vehicle.controller;

import com.xcompany.rent.vehicle.entity.Customer;
import com.xcompany.rent.vehicle.model.RequestCustomer;
import com.xcompany.rent.vehicle.service.PersonService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private PersonService<Customer> customerService;

    public CustomerController(PersonService<Customer> customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody RequestCustomer requestCustomer){
        ModelMapper modelMapper = new ModelMapper();
        var customer = modelMapper.map(requestCustomer, Customer.class);
        var created = this.customerService.create(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity getAllCustomer(){
        var people = this.customerService.getAll(Customer.class);
        return ResponseEntity.status(HttpStatus.OK).body(people);
    }

}
