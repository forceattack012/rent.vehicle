package com.xcompany.rent.vehicle.service;

import com.xcompany.rent.vehicle.entity.Car;
import org.springframework.data.domain.Page;

import java.time.OffsetDateTime;
import java.util.List;

public interface VehicleService<T> {
    long createVehicle(T vehicle);
    T updateVehicle(long id, T vehicle);
    void deleteVehicle(long id);
    List<T> findAllVehicle();
    Page<T> findAllVehicle(int page, int pageSize);
    T findAllVehicleById(long id) throws Exception;
}
