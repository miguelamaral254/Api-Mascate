package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByCpf(String cpf);
}