package com.Macate.APIRestaurante.DTOs;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.Models.Tablee;

import java.time.LocalDate;

public record ReservationDTO(Tablee tableId, Employee employeeId, Client cpf, Client phoneNumber, LocalDate reservationDate) {
}
