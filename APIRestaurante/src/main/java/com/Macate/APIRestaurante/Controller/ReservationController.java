package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.CheckinReservationDTO;
import com.Macate.APIRestaurante.DTOs.DeletReservationDTO;
import com.Macate.APIRestaurante.DTOs.ReservationDTO;
import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.Models.Reservation;
import com.Macate.APIRestaurante.Models.Tablee;
import com.Macate.APIRestaurante.repository.ClientRepository;
import com.Macate.APIRestaurante.repository.EmployeeRepository;
import com.Macate.APIRestaurante.repository.ReservationRepository;
import com.Macate.APIRestaurante.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;


    @PostMapping("/reservar")
    public ResponseEntity<String> createReservation(@RequestBody ReservationDTO reservationDTO){

        Tablee table = tableRepository.findById(reservationDTO.table())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        Reservation reservation = new Reservation();
        reservation.setTableId(reservationDTO.table());
        reservation.setEmployeeId(reservationDTO.employeeId());
        reservation.setCpf(reservationDTO.cpf());
        reservation.setName(reservationDTO.customerName());
        reservation.setPhoneNumber(reservationDTO.phoneNumber());
        reservation.setReservationDate(reservationDTO.date());
        reservation.setTime(reservationDTO.time());

        if (table.getAvailability()) {

            reservationRepository.save(reservation);

            Tablee table2 = tableRepository.findById(reservationDTO.table())
                    .orElseThrow(() -> new RuntimeException("Table not found"));
            table2.setAvailability(false);
            tableRepository.save(table2);

            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation not created successfully");
        }
    }

    @DeleteMapping("/cancellation")
    public ResponseEntity<String> cancellationReservatipn(@RequestBody DeletReservationDTO deletReservationDTO){
        Reservation reservation = reservationRepository.findById(deletReservationDTO.id()).orElseThrow(()-> new RuntimeException("Reservation not found"));
        reservationRepository.delete(reservation);
        return ResponseEntity.ok().body("Reservation cancelad");
    }

    @PutMapping("/checkin")
    public ResponseEntity<String> CheckinReservation(@RequestBody CheckinReservationDTO checkinReservationDTO){
        int id = checkinReservationDTO.id();
        Reservation reservation = reservationRepository.findById(checkinReservationDTO.id()).orElseThrow(()-> new RuntimeException("id Reservation not found"));
        Reservation reservation1 = new Reservation();
        reservation1.setCheckin(true);
        reservationRepository.save(reservation);
        return ResponseEntity.ok().body("Checkin");
    }

    @GetMapping("/reservationList")
    public ResponseEntity<List<Reservation>> reservationList() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }
}
