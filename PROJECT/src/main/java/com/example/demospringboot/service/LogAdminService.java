package com.example.demospringboot.service;

import com.example.demospringboot.entity.LogAdmin;
import com.example.demospringboot.repository.LogAdminRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LogAdminService {
    
    private final LogAdminRepository logAdminRepository;

    public LogAdminService(LogAdminRepository logAdminRepository) {
        this.logAdminRepository = logAdminRepository;
    }

    public boolean login(String adminUser, String adminPass) {
        // Menggunakan findByUsername
        Optional<LogAdmin> logAdminOptional = logAdminRepository.findByUsername(adminUser);
        if (logAdminOptional.isPresent()) {
            LogAdmin admin = logAdminOptional.get();
            return admin.getadminPass().equals(adminPass);
        }
        return false;
    }

    public Optional<LogAdmin> findByAdminUser(String adminUser) {
        // Menggunakan findByUsername
        return logAdminRepository.findByUsername(adminUser);
    }
}