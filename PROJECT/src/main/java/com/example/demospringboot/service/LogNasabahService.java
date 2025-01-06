package com.example.demospringboot.service;

import com.example.demospringboot.entity.LogNasabah;
import com.example.demospringboot.repository.LogNasabahRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogNasabahService {

    private final LogNasabahRepository logNasabahRepository;

    public LogNasabahService(LogNasabahRepository logNasabahRepository) {
        this.logNasabahRepository = logNasabahRepository;
    }

    public boolean login(String nasabahUser, String nasabahPass) {
        // Menggunakan findByUsername
        Optional<LogNasabah> logNasabahOptional = logNasabahRepository.findByUsername(nasabahUser);
        if (logNasabahOptional.isPresent()) {
            LogNasabah nasabah = logNasabahOptional.get();
            return nasabah.getNasabahPass().equals(nasabahPass);
        }
        return false;
    }

    public List<LogNasabah> getAllNasabah() {
        List<LogNasabah> nasabahList = logNasabahRepository.findAll();
        System.out.println("Data dari database: " + nasabahList);
        return nasabahList;
    }

    public Optional<LogNasabah> findByNasabahUser(String nasabahUser) {
        // Menggunakan findByUsername
        return logNasabahRepository.findByUsername(nasabahUser);
    }

    public void deleteNasabah(Integer nasabahId) {
        logNasabahRepository.deleteById(nasabahId);
    }
}