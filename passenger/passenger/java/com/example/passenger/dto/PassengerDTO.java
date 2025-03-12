package com.example.passenger.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private FlightDTO flight;
}

