package com.tinder.horse.dto.request;

import com.tinder.validation.groups.OnCreate;
import com.tinder.validation.groups.OnUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileRequest {

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @NotBlank(message = "First name cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters", groups = {OnCreate.class, OnUpdate.class})
    String firstName;

    @NotBlank(message = "Last name cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters", groups = {OnCreate.class, OnUpdate.class})
    String lastName;

    @Email(message = "Invalid email format", groups = {OnCreate.class, OnUpdate.class})
    String email;

    @NotNull(message = "Gender is required", groups = {OnCreate.class, OnUpdate.class})
    Gender gender;

    // Image

    @NotBlank (message = "Biography cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    @Size(min = 10, max = 500, message = "Biography must be between 10 and 500 characters", groups = {OnCreate.class, OnUpdate.class})
    String biography;

    @NotNull(message = "Body height cannot be null", groups = OnCreate.class)
    @Positive(message = "Body height must be positive", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 1, message = "Body height must be at least 1", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 10000, message = "Body height must not exceed 10000", groups = {OnCreate.class, OnUpdate.class})
    int bodyHeight;

    @NotNull(message = "Body length cannot be null", groups = OnCreate.class)
    @Positive(message = "Body length must be positive", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 1, message = "Body length must be at least 1", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 10000, message = "Body length must not exceed 10000", groups = {OnCreate.class, OnUpdate.class})
    int bodyLength;

    @NotBlank (message = "City cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    String city;

    @NotBlank (message = "Country cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    String country;
}
