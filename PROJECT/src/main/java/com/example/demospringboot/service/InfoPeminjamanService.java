package com.example.demospringboot.service;

import com.example.demospringboot.entity.InfoPeminjaman;
import com.example.demospringboot.repository.InfoPeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoPeminjamanService {

    @Autowired
    private InfoPeminjamanRepository repository;

    public InfoPeminjaman savePeminjaman(Integer buttonValue) {
        InfoPeminjaman peminjaman = new InfoPeminjaman();
        
        // Set values based on button pressed
        switch (buttonValue) {
            case 1:
                peminjaman.setPersen(10.0);
                peminjaman.setTenor("1 Bulan");
                break;
            case 2:
                peminjaman.setPersen(30.0);
                peminjaman.setTenor("3 Bulan");
                break;
            case 3:
                peminjaman.setPersen(50.0);
                peminjaman.setTenor("6 Bulan");
                break;
            default:
                throw new IllegalArgumentException("Invalid button value: " + buttonValue);
        }

        return repository.save(peminjaman);
    }
}
