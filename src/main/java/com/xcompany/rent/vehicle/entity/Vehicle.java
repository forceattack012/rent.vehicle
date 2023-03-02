package com.xcompany.rent.vehicle.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Vehicle {
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
}
