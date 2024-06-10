package com.Macate.APIRestaurante.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer") // Corrigido para "customer" em vez de "custumer"
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @NotBlank(message = "Name is required.")
    @Size(max = 200, message = "Name length can't be more than 200.")
    private String customerName;

    @NotBlank(message = "CPF is required.")
    @Pattern(regexp = "^\\d{11}$", message = "CPF must be 11 digits.")
    private String cpf;

    @NotBlank(message = "PhoneNumber is required.")
    @Pattern(regexp = "^\\d{11}$", message = "PhoneNumber must be 11 digits.")
    private String phoneNumber;

    private int lack; // Alterado para letras minúsculas

    // Construtores
    public Customer(String customerName, String cpf, String phoneNumber, int lack) {
        this.customerName = customerName;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.lack = lack;
    }

    public Customer() {
    }

    // Getters e Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public int getLack() {
        return lack;
    }

    public void setLack(int lack) {
        this.lack = lack;
    }
}
