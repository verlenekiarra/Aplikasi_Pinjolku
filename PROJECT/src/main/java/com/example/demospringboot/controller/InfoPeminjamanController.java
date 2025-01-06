package com.example.demospringboot.controller;

import com.example.demospringboot.entity.InfoPeminjaman;
import com.example.demospringboot.service.InfoPeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoPeminjamanController {

    @Autowired
    private InfoPeminjamanService service;

   @PostMapping("/konfirmasi")
    public String konfirmasiPilihan(@RequestParam("buttonValue") Integer buttonValue, Model model) {
    // Simpan data ke database
    InfoPeminjaman peminjaman = service.savePeminjaman(buttonValue);

    // Tambahkan pesan konfirmasi ke model
        model.addAttribute("peminjaman", peminjaman);

    //Kembali ke info
    return "infopinjamNas"; // File HTML yang sama dengan halaman info


}
}

