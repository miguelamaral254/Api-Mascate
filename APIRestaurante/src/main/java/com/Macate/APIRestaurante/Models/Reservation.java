package com.Macate.APIRestaurante.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReservation;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    @JsonManagedReference
    private Tablee table;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonManagedReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "custumer_id", nullable = false)
    private Customer customer;

    @NotNull
    private LocalDate reservationDate;
    private LocalTime time;
    private boolean checkin;


    public Reservation() {
    }

    public Reservation(int idReservation, Tablee table, Employee employee, Customer customer, LocalDate reservationDate, LocalTime time, boolean checkin) {
        this.table = table;
        this.employee = employee;
        this.customer = customer;
        this.reservationDate = reservationDate;
        this.time = time;
        this.checkin = checkin;
        this.idReservation = idReservation;
    }

    // Getters and Setters



    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Tablee getTable() {
        return table;
    }

    public void setTable(Tablee table) {
        this.table = table;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }
}
