package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TripResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String driverUsername;

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    private Integer availableSeats;

    private String status;
}
