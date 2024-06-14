package com.Macate.APIRestaurante.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Reservation> reservations;

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
