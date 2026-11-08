package com.tinder.horse.controller;

import java.util.List;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tinder.horse.dto.response.ProfileResponse;
import com.tinder.horse.mapper.HorseMapper;
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

    @GetMapping("/me")
    public ProfileResponse me(@AuthenticationPrincipal Jwt jwt) {
        String subject = jwt.getSubject();

        Horse horse = this.horseRepository.findByEmail(subject)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horse not found"));

        ProfileResponse response = HorseMapper.toResponse(horse);

        return response;
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
