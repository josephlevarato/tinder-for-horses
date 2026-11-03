package com.tinder.horse.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tinder.horse.model.Horse;
import com.tinder.horse.repository.HorseRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        // final UserDetails userDetails = loadUserByUsername(email);
        return "yay";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Horse horse = horseRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Horse not found"));
        return new User(horse.getEmail(), horse.getPassword(), new ArrayList<>());
    }
}