package com.tinder.horse.mapper;

import com.tinder.horse.dto.response.ProfileResponse;
import com.tinder.horse.model.Horse;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HorseMapper {
    
    public ProfileResponse toResponse(Horse horse) {
        return ProfileResponse.builder()
            .id(horse.getId())
            .firstName(horse.getFirstName())
            .lastName(horse.getLastName())
            .email(horse.getEmail())
            .picture(horse.getPicture())
            .gender(horse.getGender())
            .bodyHeight(horse.getBodyHeight())
            .bodyLength(horse.getBodyLength())
            .birthday(horse.getBirthday())
            .city(horse.getCity())
            .country(horse.getCountry())
            .build();
    }
}
