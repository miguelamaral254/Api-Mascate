package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.ReservationDTO;
import com.Macate.APIRestaurante.Models.Reservation;
import com.Macate.APIRestaurante.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    public ReservationRepository reservationRepository;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDTO, reservation);
        reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
    }


}
