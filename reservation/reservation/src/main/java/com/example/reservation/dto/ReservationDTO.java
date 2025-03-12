package com.example.reservation.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long passengerId;
    private Long flightId;
    private LocalDateTime reservationDate;
    private String status;
}
