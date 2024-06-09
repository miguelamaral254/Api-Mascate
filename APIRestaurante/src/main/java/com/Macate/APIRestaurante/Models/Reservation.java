package com.Macate.APIRestaurante.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReservation;

    private int tableId;

    private int employeeId;

    private String cpf;

    private String name;

    private String phoneNumber;

    @NotNull
    private LocalDate reservationDate;

    private LocalTime time;

    private boolean Checkin;



    public Reservation(int tableId, int employeeId, String cpf, String name, String phoneNumber, LocalDate reservationDate, LocalTime time, boolean Checkin) {
        this.tableId = tableId;
        this.employeeId = employeeId;
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservationDate = reservationDate;
        this.time = time;
        this.Checkin = Checkin;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }


    public Reservation() {
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getTableId() {
        return tableId;
    }

    public String getName() {
        return name;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isCheckin() {
        return Checkin;
    }

    public void setCheckin(boolean checkin) {
        Checkin = checkin;
    }

    public void setName(String name) {
        this.name = name;
    }
}
