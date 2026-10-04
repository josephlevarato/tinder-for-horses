package com.tinder.horse.controller;

import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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

    @PostMapping
    public Horse createHorse(@RequestBody Horse horse) {
        return horseRepository.save(horse);
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