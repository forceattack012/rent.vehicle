package com.xcompany.rent.vehicle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCar {
    private long id;
    private String name;
    private double price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime startRental;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime endRental;
    private double totalAmountRental;
}
