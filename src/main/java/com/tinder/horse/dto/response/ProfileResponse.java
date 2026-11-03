package com.tinder.horse.dto.response;

import java.time.LocalDate;

import com.tinder.horse.enums.Gender;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String picture;
    Gender gender;
    LocalDate birthday;
    int bodyHeight;
    int bodyLength;
    String city;
    String country;
}
