package com.tinder.horse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;

@RestController
@RequestMapping("/api/horses")
public class HorseController {
    private final HorseRepository horseRepository;

    public HorseController(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    @GetMapping
    public List<Horse> getHorses() {
        return horseRepository.findAll();
    }

    @PutMapping("/{id}")
    public Horse updateHorse(@PathVariable Long id, @RequestBody Horse horse) {
        horse.setId(id);
        return horseRepository.save(horse);
    }

    @DeleteMapping("/{id}")
    public void deleteHorse(@PathVariable Long id) {
        horseRepository.deleteById(id);
    }
}
