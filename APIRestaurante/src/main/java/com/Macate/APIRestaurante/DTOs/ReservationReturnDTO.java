package com.Macate.APIRestaurante.DTOs;

public record ReservationReturnDTO(
        String date,
        String time,
        String tableSize,
        String customerName,
        String cpf,
        String phoneNumber,
        String employeeId,
        String table
) {
}
