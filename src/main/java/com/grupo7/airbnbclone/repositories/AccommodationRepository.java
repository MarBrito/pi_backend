package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
