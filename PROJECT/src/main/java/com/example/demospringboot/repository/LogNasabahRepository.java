package com.example.demospringboot.repository;

import com.example.demospringboot.entity.LogNasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LogNasabahRepository extends JpaRepository<LogNasabah, Integer> {
    Optional<LogNasabah> findByUsername(String username);
}