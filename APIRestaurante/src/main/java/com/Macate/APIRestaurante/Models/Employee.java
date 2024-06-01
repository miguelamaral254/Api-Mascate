package com.Macate.APIRestaurante.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Name is required.")
    @Size(max = 250, message = "Name length can't be more than 250.")
    private String name;

    @Min(value = 0, message = "ReservationsMade must be a non-negative number.")
    private int reservationsMade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReservationsMade() {
        return reservationsMade;
    }

    public void setReservationsMade(int reservationsMade) {
        this.reservationsMade = reservationsMade;
    }


}
