package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Tablee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Tablee, Integer> {
    Optional<Tablee> findBytableID(int tablee);
}
