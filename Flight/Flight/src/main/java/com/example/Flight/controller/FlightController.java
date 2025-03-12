package com.example.Flight.controller;

import com.example.Flight.dto.FlightDTO;
import com.example.Flight.model.Flight;
import com.example.Flight.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Get all flights
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Get flight by ID
    @GetMapping("/{id}")
    public FlightDTO getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    // Create a flight
    @PostMapping
    public FlightDTO createFlight(@Valid @RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    // Delete a flight
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return "Flight deleted successfully.";
    }
}

