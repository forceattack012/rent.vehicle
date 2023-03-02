package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
