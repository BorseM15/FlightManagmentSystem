package com.example.Flight.service;

import com.example.Flight.dto.FlightDTO;
import com.example.Flight.exception.ResourceNotFoundException;
import com.example.Flight.model.Flight;
import com.example.Flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Convert Entity to DTO
    private FlightDTO convertToDTO(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getAirline(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime()
        );
    }

    // Get all flights
    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get flight by ID
    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
        return convertToDTO(flight);
    }

    // Save a flight
    public FlightDTO createFlight(Flight flight) {
        Flight savedFlight = flightRepository.save(flight);
        return convertToDTO(savedFlight);
    }

    // Delete a flight
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
        flightRepository.deleteById(id);
    }
}
