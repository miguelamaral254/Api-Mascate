package com.Macate.APIRestaurante.DTOs;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.Models.Tablee;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationDTO(int tableId, int employeeId, String cpf, String name, String phoneNumber, LocalDate reservationDate, LocalTime time) {
}
