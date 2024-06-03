package com.Macate.APIRestaurante.DTOs;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.Models.Tablee;

import java.time.LocalDate;

public record ReservationDTO(int tableId, int employeeId, String cpf, String phoneNumber, LocalDate reservationDate) {
}
