package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demospringboot.entity.InfoPeminjaman;

@Repository
public interface InfoPeminjamanRepository extends JpaRepository<InfoPeminjaman, Integer> {
}
