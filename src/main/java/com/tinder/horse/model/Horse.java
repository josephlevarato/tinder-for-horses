package com.tinder.horse.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tinder.horse.enums.Gender;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity(name = "horses")
@Data 
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
public class Horse {

    public Horse() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String picture;
    private String biography;
    private int bodyHeight;
    private int bodyLength;
    private LocalDate birthday;
    private String city;
    private String country;
    private boolean isActive;
    @Nullable
    private LocalDateTime emailVerifiedAt;
    private LocalDateTime lastActiveAt;

    @CreatedDate
    @Column(updatable =  false)
    private LocalDateTime createdAt;

    @LastModifiedDate 
    private LocalDateTime updatedAt;
}

