package com.example.demo.controller;

import com.example.demo.dto.TripCreateDto;
import com.example.demo.dto.TripResponseDto;
import com.example.demo.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trips")
public class TripController {
    TripService tripService;

    @PostMapping()
    public ResponseEntity<TripResponseDto> postTrip(@RequestBody @Valid TripCreateDto tripCreateDto) {
        TripResponseDto tripResponseDto = tripService.createTrip(tripCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripResponseDto);
    }
}
