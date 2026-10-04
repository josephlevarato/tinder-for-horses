package com.tinder.horse.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography (String bio) {
        this.biography = bio;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int height) {
        this.bodyHeight = height;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int length) {
        this.bodyLength = length;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public LocalDateTime getLastActive() {
        return lastActiveAt;
    }

    public void setLastActive(LocalDateTime active) {
        this.lastActiveAt = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

