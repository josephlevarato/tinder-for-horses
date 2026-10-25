package com.tinder.horse.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "horses")
@Data 
@Builder
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String picture;
    private String biography;
    private int bodyHeight;
    private int bodyLength;
    private String city;
    private String country;
    private boolean isActive;
    private LocalDateTime lastActiveAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

