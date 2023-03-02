package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
