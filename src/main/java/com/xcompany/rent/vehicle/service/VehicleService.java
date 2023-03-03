package com.xcompany.rent.vehicle.service;

import java.util.List;

public interface VehicleService<T> {
    List<T> findAllVehicle();
    T findAllVehicleById(long id) throws Exception;
}
