package com.tinder.horse.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinder.horse.dto.request.ProfileRequest;
import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;
import com.tinder.horse.services.ProfileService;
import com.tinder.validation.groups.OnCreate;

@RestController
@RequestMapping("/api/horses")
public class HorseController {
    private final HorseRepository horseRepository;
    private final ProfileService profileService;

    public HorseController(HorseRepository horseRepository, ProfileService profileService) {
        this.horseRepository = horseRepository;
        this.profileService = profileService;
    }

    @GetMapping
    public List<Horse> getHorses() {
        return horseRepository.findAll();
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Horse> createHorse(
        @Validated(OnCreate.class)
        @ModelAttribute ProfileRequest request
    ) throws IOException {
        this.profileService.createProfile(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
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
