package com.Macate.APIRestaurante.DTOs;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Employee;
import com.Macate.APIRestaurante.Models.Tablee;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationDTO(
        LocalDate date,
        LocalTime time,
        String customerName,
        String cpf,
        String phoneNumber,
        int employeeId,
        int table
) {
}

