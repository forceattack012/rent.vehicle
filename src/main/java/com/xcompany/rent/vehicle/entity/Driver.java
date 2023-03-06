package com.xcompany.rent.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="license_id", nullable = false)
    private String licenseId;
    @Column(name="license_expire", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate licenseExpire;
    @Column(name="price", nullable = false)
    private double price;
    @Column(name="is_valid")
    private boolean isValid;
    @Column(name="rating")
    private int rating;

    public boolean getIsValid() {
        if(licenseExpire.isBefore(LocalDate.now())){
            return false;
        }
        return true;
    }
}
