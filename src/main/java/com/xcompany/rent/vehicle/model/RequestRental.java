package com.xcompany.rent.vehicle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xcompany.rent.vehicle.entity.Car;
import com.xcompany.rent.vehicle.entity.Customer;
import com.xcompany.rent.vehicle.entity.Driver;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestRental {
    @JsonProperty(required = true)
    @NotNull(message = "please select startDate")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    private String startDate;
    @JsonProperty(required = true)
    @NotNull(message = "please select endDate")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    private String endDate;
    @JsonProperty
    @NotNull
    private long carId;
    @JsonProperty
    @NotNull
    private Customer customer;
    @Null
    private long driverId;
    private double totalAmount;

    private LocalDateTime endDatex;
}
