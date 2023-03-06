package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.RentalCar;
import com.xcompany.rent.vehicle.exception.NotFoundException;
import com.xcompany.rent.vehicle.model.RequestRental;
import com.xcompany.rent.vehicle.repository.CarRepository;
import com.xcompany.rent.vehicle.repository.DriverRepository;
import com.xcompany.rent.vehicle.repository.RentalCarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RentalCarService implements RentalService<RentalCar, RequestRental>{
    private static Logger logger = Logger.getLogger(RentalCarService.class.getName());
    private static RentalCarRepository rentalCarRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;
    public RentalCarService(RentalCarRepository rentalCarRepository){
        this.rentalCarRepository = rentalCarRepository;
    }

    @Override
    public RentalCar createRental(RequestRental rentalCar) {
        var car = this.carRepository.findByIdAndIsUsed(rentalCar.getCarId(), true);
        if(car.isEmpty()){
            throw new NotFoundException("id not found");
        }

        logger.info("driver : " + rentalCar.getDriverId());

        RentalCar rental = new RentalCar();
        rental.setCar(car.get());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(rentalCar.getEndDate(), formatter);
        rental.setEndDate(dateTime);
        rental.setCustomer(rentalCar.getCustomer());
        dateTime = LocalDateTime.parse(rentalCar.getEndDate(), formatter);
        rental.setStartDate(dateTime);
        rental.setTotalAmount(rentalCar.getTotalAmount());
        rental.setSuccess(true);

        if(rentalCar.getDriverId() != 0){
            var driver = driverRepository.findById(rentalCar.getDriverId());
            if(driver.isPresent()){
                rental.setDriver(driver.get());
            }
        }

        return this.rentalCarRepository.save(rental);
    }

    @Override
    public RentalCar updateRental(long id, RequestRental rentalCar) {
        ModelMapper modelMapper = new ModelMapper();
        RentalCar rental = modelMapper.map(rentalCar, RentalCar.class);
        return this.rentalCarRepository.findById(id).map(r -> {
            r.setCar(rental.getCar());
            r.setCustomer(rental.getCustomer());
            r.setStartDate(rental.getStartDate());
            r.setEndDate(rental.getEndDate());
            r.setDriver(rental.getDriver());
            r.setTotalAmount(rental.getTotalAmount());

            return this.rentalCarRepository.save(r);
        }).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public void deleteRental(long id) {
        this.rentalCarRepository.findById(id).map(r -> {
            this.rentalCarRepository.delete(r);
            return r;
        }).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public List<RentalCar> getAllRental() {
        return this.rentalCarRepository.findAll();
    }

    @Override
    public RentalCar getRentalById(long id) {
        return this.rentalCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
    }
}
