package com.xcompany.rent.vehicle.entity;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="car")
public class Car extends Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Car(String name, double price){
        super(name, price);
    }
}
