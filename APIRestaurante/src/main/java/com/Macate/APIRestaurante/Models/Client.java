package com.Macate.APIRestaurante.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    @NotBlank(message = "Name is required.")
    @Size(max = 200, message = "Name length can't be more than 200.")
    private String name;

    @NotBlank(message = "CPF is required.")
    @Pattern(regexp = "^\\d{11}$", message = "CPF must be 11 digits.")
    private String cpf;

    @NotBlank(message = "PhoneNumber is required.")
    @Pattern(regexp = "^\\d{14}$", message = "PhoneNumber must be 14 digits.")
    private String phoneNumber;


    public Client(String name, String cpf, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}
