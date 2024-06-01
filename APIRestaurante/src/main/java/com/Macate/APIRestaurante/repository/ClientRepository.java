package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
