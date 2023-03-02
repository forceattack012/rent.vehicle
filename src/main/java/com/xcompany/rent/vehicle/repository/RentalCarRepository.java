package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
}
