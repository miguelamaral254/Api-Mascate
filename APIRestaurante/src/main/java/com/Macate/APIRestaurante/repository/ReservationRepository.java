package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
