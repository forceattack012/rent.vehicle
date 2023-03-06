package com.xcompany.rent.vehicle.service;

import java.util.List;

public interface RentalService<T, J> {
    T createRental(J car);
    T updateRental(long id, J car);
    void deleteRental(long id);
    List<T> getAllRental();
    T getRentalById(long id);
}
