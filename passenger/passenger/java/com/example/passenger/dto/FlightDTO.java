package com.example.passenger.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Long id;

    @NotBlank(message = "Flight number is required")
    private String flightNumber;

    @NotBlank(message = "Airline is required")
    private String airline;

    @NotBlank(message = "Origin is required")
    private String origin;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Departure time is required")
    @Future(message = "Departure time must be in the future")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    @Future(message = "Arrival time must be in the future")
    private LocalDateTime arrivalTime;

// // Constructor to convert Entity to DTO
//    public FlightDTO(Long id, String flightNumber, String airline, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        this.id = id;
//        this.flightNumber = flightNumber;
//        this.airline = airline;
//        this.origin = origin;
//        this.destination = destination;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//    }

    // Getters and Setters
    // Lombok can be used if preferred
}
