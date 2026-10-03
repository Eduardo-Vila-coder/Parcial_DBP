package com.example.demo.service;

import com.example.demo.dto.TripCreateDto;
import com.example.demo.dto.TripResponseDto;
import com.example.demo.entity.Trip;
import com.example.demo.esception.placeException;
import com.example.demo.repository.TripRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TripService {
    ModelMapper modelMapper;
    TripRepository tripRepository;

    public TripResponseDto createTrip(TripCreateDto tripCreateDto) {
        if (Objects.equals(tripCreateDto.getDestination(), tripCreateDto.getOrigin())) {
            throw new placeException("Origin and destination cannot be the same");
        }

        // Validacion de viajes superpuestos

        Trip trip = modelMapper.map(tripCreateDto, Trip.class);     /// Usar bien el model Mapper
        trip = tripRepository.save(trip);
        return modelMapper.map(trip, TripResponseDto.class);
    }
}
