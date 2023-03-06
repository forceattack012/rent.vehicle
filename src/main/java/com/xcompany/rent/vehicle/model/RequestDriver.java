package com.xcompany.rent.vehicle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Setter
@Getter
@Data
public class RequestDriver {
    private String citizenId;
    private String name;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    private String licenseId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate licenseExpire;
    private double price;
    private int rating;

}
