package com.Macate.APIRestaurante.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "restaurant_table")
public class Tablee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableID;

    @NotNull(message = "Availability is required.")
    private Boolean availability;

    @Min(value = 1, message = "Number of chairs must be between 1 and 20.")
    @Max(value = 20, message = "Number of chairs must be between 1 and 20.")
    private int chairs;

    @NotBlank(message = "Type is required.")
    private String type;

    @NotBlank(message = "Size is required.")
    private String size;


    public Tablee(Boolean availability, int chairs, String type, String size) {
        this.availability = availability;
        this.chairs = chairs;
        this.type = type;
        this.size = size;
    }

    public Tablee(){
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
