package com.Macate.APIRestaurante.DTOs;

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

    
    public String customerName() {
        return customerName;
    }

    public String cpf() {
        return cpf;
    }

    public String phoneNumber() {
        return phoneNumber;
    }
}
