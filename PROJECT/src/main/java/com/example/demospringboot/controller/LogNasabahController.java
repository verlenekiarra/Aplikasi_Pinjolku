package com.example.demospringboot.controller;

import com.example.demospringboot.entity.LogNasabah;
import com.example.demospringboot.service.LogNasabahService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Optional;

@Controller
@RequestMapping("/nasabah")
public class LogNasabahController {

    @Autowired
    private LogNasabahService logNasabahService;

    @PostMapping("/login")
    public String login(@RequestParam String nasabahUser, 
                        @RequestParam String nasabahPass, 
                        Model model) {
        boolean isLoginSuccessful = logNasabahService.login(nasabahUser, nasabahPass);

        if (isLoginSuccessful) {
            // Jika login berhasil, arahkan ke halaman beranda
            model.addAttribute("username", nasabahUser);
            return "beranda"; // Nama file HTML untuk halaman beranda
        } else {
            // Jika login gagal, periksa apakah username ada di database
            Optional<LogNasabah> logNasabahOptional = logNasabahService.findByNasabahUser(nasabahUser);
            
            // Jika username tidak ditemukan
            if (logNasabahOptional.isEmpty()) {
                model.addAttribute("errorMessage", "Username tidak ditemukan!");
            } else {
                model.addAttribute("errorMessage", "Password salah!");
            }

            // Kembalikan ke halaman login dengan pesan kesalahan
            return "LogNasabah"; // Nama file HTML untuk halaman login
        }
    }

    @PostMapping("/beranda")
    public String beranda() {
        return "beranda"; // Render file beranda.html
    }

    // TAMBAHAN
    @GetMapping("/nasabahlist")
public String listNasabah(Model model) {
    // Mengambil semua data nasabah dari layanan
    List<LogNasabah> nasabahList = logNasabahService.getAllNasabah();
    // Menambahkan daftar nasabah ke model
    model.addAttribute("nasabahList", nasabahList);
    
    // Mengembalikan nama file HTML yang akan dirender
    return "nasabahlist";
}


    @PostMapping("/delete/{nasabahId}")
    public String deleteNasabah(@PathVariable Integer nasabahId) {
        // Menghapus data nasabah berdasarkan ID
        logNasabahService.deleteNasabah(nasabahId);
        return "redirect:/nasabah/list"; // Refresh halaman setelah penghapusan
    }
}

