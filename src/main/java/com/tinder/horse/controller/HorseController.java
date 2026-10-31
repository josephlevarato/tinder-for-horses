package com.tinder.horse.controller;

import com.tinder.horse.dto.request.ProfileRequest;
import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;
import com.tinder.horse.services.ProfileService;
import com.tinder.validation.groups.OnCreate;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.*;

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

    /*
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Horse> createHorse(
        @Validated(OnCreate.class)
        @RequestPart ProfileRequest request
    ) throws IOException {
        this.profileService.createProfile(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    */

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Horse> createHorse(
        @Validated(OnCreate.class) @RequestPart("picture") ProfileRequest request,
        @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        this.profileService.createProfile(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
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
