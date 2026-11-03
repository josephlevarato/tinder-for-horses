package com.tinder.horse.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.tinder.horse.config.PasswordEncoder;
import com.tinder.horse.dto.request.ProfileRequest;
import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;
import com.tinder.s3.service.S3Service;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {

    private final S3Service s3Service;
    private final HorseRepository horseRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfileService(S3Service s3Service, HorseRepository horseRepository, PasswordEncoder encoder) {
        this.s3Service = s3Service;
        this.horseRepository = horseRepository;
        this.passwordEncoder = encoder;
    }

    @Transactional
    public void createProfile(ProfileRequest request) throws IOException {

        String imgPath = this.s3Service.uploadFile(request.getPicture());

        Horse horse = Horse.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(this.passwordEncoder.encode(request.getPassword()))
            .gender(request.getGender())
            .picture(imgPath)
            .birthday(request.getBirthday())
            .biography(request.getBiography())
            .bodyHeight(request.getBodyHeight())
            .bodyLength(request.getBodyLength())
            .city(request.getCity())
            .country(request.getCountry())
            .build();

        this.horseRepository.save(horse);
    }
}
