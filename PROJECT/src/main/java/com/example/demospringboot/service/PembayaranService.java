package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.Pembayaran;
import com.example.demospringboot.entity.Peminjaman;
import com.example.demospringboot.repository.PembayaranRepository;

@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    public void savePembayaran(Double nominal,String metodePembayaran,Integer idpeminjaman) {
        Pembayaran pembayaran = new Pembayaran();
        // pembayaran.setTenor(duration);
        pembayaran.setNominal(nominal);
        pembayaran.setMetodePembayaran(metodePembayaran);

        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setIdpeminjaman(idpeminjaman);
        pembayaran.setPeminjaman(peminjaman);
        pembayaranRepository.save(pembayaran);
    }
}