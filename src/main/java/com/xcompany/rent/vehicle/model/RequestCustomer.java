package com.xcompany.rent.vehicle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Setter
@Getter
@Data
public class RequestCustomer {
    @NotNull(message = "please citizenId")
    @JsonProperty(required = true)
    private String citizenId;
    @NotNull
    @JsonProperty(required = true)
    private String name;
    @NotNull
    @JsonProperty(required = true)
    private String lastName;
    @NotNull
    @JsonProperty(required = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
}
