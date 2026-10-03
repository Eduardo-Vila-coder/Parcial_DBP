package com.example.demo.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatRequestCreateDto {
    @NotNull
    private Long tripId;
    @NotNull
    private Long passengerId;

    @NotNull
    @Future
    private ZonedDateTime requestedAt;
}
