package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
