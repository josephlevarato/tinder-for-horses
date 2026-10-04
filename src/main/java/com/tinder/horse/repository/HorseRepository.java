package com.tinder.horse.repository;

import com.tinder.horse.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {}

