package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Customer;
import com.xcompany.rent.vehicle.entity.Driver;
import com.xcompany.rent.vehicle.repository.CustomerRepository;
import com.xcompany.rent.vehicle.repository.DriverRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService<T> {
    private DriverRepository driverRepo;
    private CustomerRepository customerRepository;
    public PersonService(DriverRepository driverRepository, CustomerRepository customerRepository){
        this.driverRepo = driverRepository;
        this.customerRepository = customerRepository;
    }
    public T create(T person) {
        if(person.getClass() == Driver.class){
            var driver = (Driver)person;
            driver.setValid(driver.getIsValid());
            return (T) this.driverRepo.save((Driver)person);
        }
        return (T)this.customerRepository.save((Customer)person);
    }

    public List<T> getAll(Class type){
        if(type == Driver.class){
            return (List<T>) this.driverRepo.findAll();
        }
        return (List<T>) this.customerRepository.findAll();
    }

    public List<T> getAll(Class type, int page, int pageSize, String sortName){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(sortName));
        if(type == Driver.class){
            return (List<T>) this.driverRepo.findAll(pageable).toList();
        }
        return (List<T>) this.customerRepository.findAll(pageable).toList();
    }
}
