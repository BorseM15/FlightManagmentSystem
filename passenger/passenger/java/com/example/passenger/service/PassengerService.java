package com.example.passenger.service;

import com.example.passenger.model.Passenger;
import com.example.passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
	

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

    public List<Passenger> getPassengersByFlightId(Long flightId) {
        return passengerRepository.findByFlightId(flightId);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        Passenger existingPassenger = getPassengerById(id);
        existingPassenger.setFirstName(updatedPassenger.getFirstName());
        existingPassenger.setLastName(updatedPassenger.getLastName());
        existingPassenger.setEmail(updatedPassenger.getEmail());
        existingPassenger.setPhone(updatedPassenger.getPhone());
        return passengerRepository.save(existingPassenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}

