package com.example.demospringboot.service;

import com.example.demospringboot.entity.InfoPeminjaman;
import com.example.demospringboot.entity.Peminjaman;
import com.example.demospringboot.repository.InfoPeminjamanRepository;
import com.example.demospringboot.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private InfoPeminjamanRepository infoPeminjamanRepository;

    @Autowired
    private PembayaranCalculator pembayaranCalculator; 
    

    public Peminjaman savePeminjaman(Double amount, String duration, Double persen) {
          // Buat InfoPeminjaman baru
        InfoPeminjaman infoPeminjaman = new InfoPeminjaman();
        infoPeminjaman.setTenor(duration);
        infoPeminjaman.setPersen(persen);
        
        // Simpan InfoPeminjaman terlebih dahulu
        infoPeminjaman = infoPeminjamanRepository.save(infoPeminjaman);

        //Total pinjaman dari interface
        Double totalPinjaman = pembayaranCalculator.calculateTotalPaymentWithInterest(amount, persen);
        
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setNominal(amount);
        peminjaman.setInfoPeminjaman(infoPeminjaman);  // Setting the foreign key reference to InfoPeminjaman
        peminjaman.setPersen(persen);
        peminjaman.setTotalPinjaman(totalPinjaman); //tambahan total
        return peminjamanRepository.save(peminjaman); //ini menyimpan data
    }
}


