package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.LogNasabah;
import com.example.demospringboot.repository.LogNasabahRepository;

@Service
public class SignUpService {

    @Autowired
    private LogNasabahRepository logNasabahRepository;

    // Method to register a new user
    public boolean signUp(String username, String password) {
        // Check if the username already exists
        if (logNasabahRepository.findByUsername(username).isPresent()) {
            // Username already exists
            return false;
        }

        // Create a new LogNasabah entity if username doesn't exist
        LogNasabah newNasabah = new LogNasabah();
        newNasabah.setNasabahUser(username);
        newNasabah.setNasabahPass(password);

        // Save it to the repository (database)
        LogNasabah savedNasabah = logNasabahRepository.save(newNasabah);

        // Return true if the user was saved successfully
        return savedNasabah != null;
    }
}
