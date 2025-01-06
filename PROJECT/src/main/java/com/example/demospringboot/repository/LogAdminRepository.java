package com.example.demospringboot.repository;

import com.example.demospringboot.entity.LogAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LogAdminRepository extends JpaRepository<LogAdmin, Integer> {
    Optional<LogAdmin> findByUsername(String username);
}