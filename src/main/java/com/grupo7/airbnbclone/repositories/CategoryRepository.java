package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
