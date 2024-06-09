package com.Macate.APIRestaurante.Controller;

import com.Macate.APIRestaurante.DTOs.CheckinReservationDTO;
import com.Macate.APIRestaurante.DTOs.CheckoutDTO;
import com.Macate.APIRestaurante.DTOs.DeletReservationDTO;
import com.Macate.APIRestaurante.DTOs.ReservationDTO;
import com.Macate.APIRestaurante.Models.Reservation;
import com.Macate.APIRestaurante.Models.Tablee;
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
        try {
            Tablee table = tableRepository.findById(reservationDTO.table())
                    .orElseThrow(() -> new RuntimeException("Table not found"));

            if (table.getAvailability()) {
                Reservation reservation = new Reservation();
                reservation.setTableId(reservationDTO.table());
                reservation.setEmployeeId(reservationDTO.employeeId());
                reservation.setCpf(reservationDTO.cpf());
                reservation.setName(reservationDTO.customerName());
                reservation.setPhoneNumber(reservationDTO.phoneNumber());
                reservation.setReservationDate(reservationDTO.date());
                reservation.setTime(reservationDTO.time());

                reservationRepository.save(reservation);

                table.setAvailability(false);
                tableRepository.save(table);

                return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table is not available");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/cancellation")
    public ResponseEntity<String> cancellationReservation(@RequestBody DeletReservationDTO deletReservationDTO){
        try {
            Reservation reservation = reservationRepository.findById(deletReservationDTO.id())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));

            reservationRepository.delete(reservation);

            // Update table availability after deleting reservation
            Tablee table = tableRepository.findById(reservation.getTableId())
                    .orElseThrow(() -> new RuntimeException("Table not found"));
            table.setAvailability(true);
            tableRepository.save(table);

            return ResponseEntity.ok().body("Reservation cancelled");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/checkin")
    public ResponseEntity<String> checkinReservation(@RequestBody CheckinReservationDTO checkinReservationDTO){
        try {
            Reservation reservation = reservationRepository.findById(checkinReservationDTO.id())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));

            reservation.setCheckin(true);
            reservationRepository.save(reservation);

            return ResponseEntity.ok().body("Checkin successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/checkout")
    public ResponseEntity<String> checkoutReservation(@RequestBody CheckoutDTO checkoutDTO){
        try {
            Reservation reservation = reservationRepository.findById(checkoutDTO.tableID())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));

            reservation.setCheckin(false);
            reservationRepository.save(reservation);

            // Update table availability after checkout
            Tablee table = tableRepository.findById(reservation.getTableId())
                    .orElseThrow(() -> new RuntimeException("Table not found"));
            table.setAvailability(true);
            tableRepository.save(table);

            return ResponseEntity.ok().body("Checkout successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/reservationList")
    public ResponseEntity<List<Reservation>> reservationList() {
        try {
            List<Reservation> reservations = reservationRepository.findAll();
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
