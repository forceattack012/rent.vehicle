package com.xcompany.rent.vehicle.repository;

import com.xcompany.rent.vehicle.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT c.id, c.name, c.price, c.is_used " +
            "FROM car c LEFT JOIN rental_car r ON (c.id = r.car_id and start_date >= ?1 and end_date <= ?2 ) " +
            "WHERE r is NULL AND c.is_used = true " +
            "ORDER BY c.id", nativeQuery = true)
    List<Car> findAllCarIsEmpty(LocalDateTime startDate, LocalDateTime endDate);
    Optional<Car> findByIdAndIsUsed(long id, boolean isUsed);


}
