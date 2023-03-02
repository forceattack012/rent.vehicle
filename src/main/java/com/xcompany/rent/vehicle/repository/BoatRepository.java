package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
}
