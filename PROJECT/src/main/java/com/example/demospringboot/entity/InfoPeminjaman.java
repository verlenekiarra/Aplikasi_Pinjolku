package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class InfoPeminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idinfo;
    private Double persen;
    private String tenor;  
}
