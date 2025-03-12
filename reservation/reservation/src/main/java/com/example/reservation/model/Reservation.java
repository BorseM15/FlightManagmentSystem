package com.example.reservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Passenger is required")
    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @NotNull(message = "Flight is required")
    @Column(name = "flight_id", nullable = false)
    private Long flightId;  // Stores flight reference (not an object)

    @Future(message = "Reservation date must be in the future")
    private LocalDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    private ReservationStatus status;
}

