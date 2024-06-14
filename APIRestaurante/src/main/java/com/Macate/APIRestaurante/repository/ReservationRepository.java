package com.Macate.APIRestaurante.repository;

import com.Macate.APIRestaurante.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByTableAndReservationDateAndTime(int tableId, LocalDate date, LocalTime time);

}
