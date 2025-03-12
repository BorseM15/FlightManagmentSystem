package com.example.reservation.controller;

import com.example.reservation.model.Reservation;
import com.example.reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Reservation> getReservationsByPassenger(@PathVariable Long passengerId) {
        return reservationService.getReservationsByPassengerId(passengerId);
    }

    @GetMapping("/flight/{flightId}")
    public List<Reservation> getReservationsByFlight(@PathVariable Long flightId) {
        return reservationService.getReservationsByFlightId(flightId);
    }

    @PostMapping
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @Valid @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "Reservation deleted successfully";
    }
}
