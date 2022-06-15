package com.grupo7.airbnbclone.repositories;

import com.grupo7.airbnbclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
