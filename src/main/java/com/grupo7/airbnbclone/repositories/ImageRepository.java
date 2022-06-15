package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
