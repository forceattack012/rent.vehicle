package com.xcompany.rent.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name="end_date", nullable = false)
    private LocalDateTime endDate;
    @Column(name="total_amount", nullable = false)
    private Double totalAmount;
}
