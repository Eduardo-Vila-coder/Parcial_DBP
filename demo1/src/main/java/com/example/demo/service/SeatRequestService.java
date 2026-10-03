package com.example.demo.service;

import com.example.demo.dto.SeatRequestCreateDto;
import com.example.demo.dto.SeatRequestResponseDto;
import com.example.demo.entity.SeatRequest;
import com.example.demo.entity.Trip;
import com.example.demo.esception.TripFullException;
import com.example.demo.esception.TripNotFoundException;
import com.example.demo.repository.SeatRequestRepository;
import com.example.demo.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatRequestService {
    ModelMapper modelMapper;
    SeatRequestRepository seatRequestRepository;
    TripRepository tripRepository;

    public SeatRequestResponseDto createSeatRequest(Long tripId, SeatRequestCreateDto seatRequestCreateDto) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("The trip was not founded"));

        if (trip.getAvailableSeats() == 0) {
            throw new TripFullException("The trip does not have available seats");
        }

        SeatRequest seatRequest = modelMapper.map(seatRequestCreateDto, SeatRequest.class);
        seatRequest = seatRequestRepository.save(seatRequest);
        return modelMapper.map(seatRequest, SeatRequestResponseDto.class);
    }


}
