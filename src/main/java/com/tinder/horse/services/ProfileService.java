package com.tinder.horse.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.tinder.horse.dto.request.ProfileRequest;
import com.tinder.horse.model.Horse;
import com.tinder.s3.service.S3Service;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {

    private final S3Service s3Service;

    public ProfileService(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Transactional
    public void createProfile(ProfileRequest request) throws IOException {

        String imgPath = this.s3Service.uploadFile(request.getImage());

        Horse.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .gender(request.getGender())
            .picture(imgPath)
            .biography(request.getBiography())
            .bodyHeight(request.getBodyHeight())
            .bodyLength(request.getBodyLength())
            .city(request.getCity())
            .country(request.getCountry())
            .build();
    }
}
