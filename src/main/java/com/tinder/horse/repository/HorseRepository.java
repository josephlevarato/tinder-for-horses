package com.tinder.horse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinder.horse.model.Horse;

public interface HorseRepository extends JpaRepository<Horse, Long> {
    Optional<Horse> findByEmail(String email);
}

