package com.xcompany.rent.vehicle.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @Column(name="citizen_id", nullable = false)
    private String citizenId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name="birth_date", nullable = false)
    private LocalDateTime birthDate;
}
