package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.model.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByPassengerId(Long passengerId);
    List<Reservation> findByFlightId(Long flightId);
}
