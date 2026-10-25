package com.tinder.horse.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinder.horse.dto.request.ProfileRequest;
import com.tinder.horse.model.Horse;
import com.tinder.s3.service.S3Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ProfileService {

    @Autowired
    private S3Service s3Service;
    
    @Transactional
    public void createProfile(ProfileRequest request)
    {
        try {
            String imgPath = s3Service.uploadFile(request.getImage());

            Horse.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .picture(imgPath)
                // .gender(request.getGender())

            .build();

            // return 
        } catch (IOException e) {

        }        
    }
}
