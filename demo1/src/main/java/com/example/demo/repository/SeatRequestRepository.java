package com.example.demo.repository;

import com.example.demo.entity.SeatRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRequestRepository extends JpaRepository<SeatRequest, Long> {
}
