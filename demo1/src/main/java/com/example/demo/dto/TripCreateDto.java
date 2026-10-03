package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TripCreateDto {
    @NotNull
    @Future
    private ZonedDateTime departureTime;

    @NotBlank
    private String origin;
    @NotBlank
    private String destination;

    @NotNull
    @Min(1)
    @Max(6)
    private Integer capacity;
}
