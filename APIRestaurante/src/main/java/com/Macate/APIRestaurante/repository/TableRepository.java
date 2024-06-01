package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Client;
import com.Macate.APIRestaurante.Models.Tablee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tablee, Integer> {
}
