package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demospringboot.entity.Pembayaran;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {
}
