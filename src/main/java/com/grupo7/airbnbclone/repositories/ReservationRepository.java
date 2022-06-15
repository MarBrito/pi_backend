package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
