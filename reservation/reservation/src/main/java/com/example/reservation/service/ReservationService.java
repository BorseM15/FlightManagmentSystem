package com.example.reservation.service;

import com.example.reservation.model.Reservation;
import com.example.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<Reservation> getReservationsByPassengerId(Long passengerId) {
        return reservationRepository.findByPassengerId(passengerId);
    }

    public List<Reservation> getReservationsByFlightId(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id);
        existingReservation.setReservationDate(updatedReservation.getReservationDate());
        existingReservation.setStatus(updatedReservation.getStatus());
        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

