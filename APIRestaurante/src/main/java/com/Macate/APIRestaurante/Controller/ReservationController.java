package com.Macate.APIRestaurante.Controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("reservar")
    public ResponseEntity<String> createReservation(@RequestBody ReservationDTO reservationDTO){

        Tablee table = tableRepository.findById(reservationDTO.tableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));
        Employee employee = employeeRepository.findById(reservationDTO.employeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Client client = clientRepository.findByCpf(reservationDTO.cpf())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Reservation reservation = new Reservation();
        reservation.setTableId(table);
        reservation.setEmployeeId(employee);
        reservation.setCpf(client);
        reservation.setPhoneNumber(reservationDTO.phoneNumber());
        reservation.setReservationDate(reservationDTO.reservationDate());

        if (table.getAvailability()) {

            reservationRepository.save(reservation);

            Tablee table2 = tableRepository.findById(reservationDTO.tableId())
                    .orElseThrow(() -> new RuntimeException("Table not found"));
            table2.setAvailability(false);
            tableRepository.save(table2);

            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation not created successfully");
        }
    }
}
