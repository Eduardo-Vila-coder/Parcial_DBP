package com.example.demo.controller;

import com.example.demo.dto.SeatRequestCreateDto;
import com.example.demo.dto.SeatRequestResponseDto;
import com.example.demo.dto.TripCreateDto;
import com.example.demo.dto.TripResponseDto;
import com.example.demo.service.SeatRequestService;
import com.example.demo.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trips")
public class TripController {
    TripService tripService;
    SeatRequestService seatRequestService;

    @PostMapping()
    public ResponseEntity<TripResponseDto> postTrip(@RequestBody @Valid TripCreateDto tripCreateDto) {
        TripResponseDto tripResponseDto = tripService.createTrip(tripCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripResponseDto);
    }

    @PostMapping("/{tripId}/seat-requests")
    public ResponseEntity<SeatRequestResponseDto> postTrip(@PathVariable Long tripId, @RequestBody @Valid SeatRequestCreateDto seatRequestCreateDto) {
        seatRequestService.createSeatRequest()
    }
}
