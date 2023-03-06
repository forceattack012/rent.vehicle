package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.exception.NotFoundException;
import com.xcompany.rent.vehicle.model.ResponseCar;
import com.xcompany.rent.vehicle.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CarService implements VehicleService<Car>{
    private static Logger logger = Logger.getLogger(CarService.class.getName());
    private final CarRepository carRepository;
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public long createVehicle(Car vehicle) {
        var result = this.carRepository.save(vehicle);
        return result.getId();
    }

    @Override
    public Car updateVehicle(long id, Car vehicle) {
       var carUpdate = this.carRepository.findById(id).map(r -> {
            r.setName(vehicle.getName());
            r.setPrice(vehicle.getPrice());
            r.setUsed(vehicle.isUsed());
            return this.carRepository.save(r);
        }).orElseThrow(() -> {
            String message = String.format("id %d not found", id);
            return new NotFoundException(message);
       });

       return carUpdate;
    }

    @Override
    public void deleteVehicle(long id) {
        Optional<Car> car = this.carRepository.findById(id);
        if(car.isEmpty()){
            throw new NotFoundException(String.format("id %d not found", id));

        }
        this.carRepository.delete(car.get());
    }

    @Override
    public List<Car> findAllVehicle() {
        return this.carRepository.findAll();
    }

    @Override
    public Page<Car> findAllVehicle(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Car> cars = this.carRepository.findAll(pageable);
        return cars;
    }

    @Override
    public Car findAllVehicleById(long id) throws Exception {
        var car = this.carRepository.findById(id).orElse(null);
        if(car == null){
            return new Car();
        }
        return car;
    }

    public List<ResponseCar> findAllVehicleIsEmptyByDate(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        var cars = this.carRepository.findAllCarIsEmpty(startDate, endDate);

        List<ResponseCar> responseCarList = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            RentalCalculatorService rentalCar = new RentalCarCalculator(cars.get(i));
            var total = rentalCar.calRental(startDate, endDate);
            logger.info(MessageFormat.format("total rent {0}", total));

            ResponseCar responseCar = new ResponseCar();
            responseCar.setId(cars.get(i).getId());
            responseCar.setStartRental(startDate);
            responseCar.setEndRental(endDate);
            responseCar.setName(cars.get(i).getName());
            responseCar.setPrice(cars.get(i).getPrice());
            responseCar.setTotalAmountRental(total);

            responseCarList.add(i, responseCar);
        }

        return responseCarList;
    }
}
