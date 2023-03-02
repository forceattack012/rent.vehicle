package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.RentalBoat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalBoatRepository extends JpaRepository<RentalBoat, Long> {
}
