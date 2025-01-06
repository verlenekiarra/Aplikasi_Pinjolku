package com.example.demospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demospringboot.entity.LogAdmin;
import com.example.demospringboot.entity.LogNasabah;
import com.example.demospringboot.repository.LogNasabahRepository;
import com.example.demospringboot.service.LogAdminService;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class LogAdminController {

    @Autowired
    private LogAdminService logAdminService;

    @Autowired
    private LogNasabahRepository logNasabahRepository;

    @PostMapping("/login")
    public String login(@RequestParam String adminUser, 
                        @RequestParam String adminPass, 
                        Model model) {
        boolean isLoginSuccessful = logAdminService.login(adminUser, adminPass);

        if (isLoginSuccessful) {
            // Jika login berhasil, arahkan ke halaman beranda
            model.addAttribute("username", adminUser);
            return "berandaAdmin"; // Nama file HTML untuk halaman beranda
        } else {
            // Jika login gagal, periksa apakah username ada di database
            Optional<LogAdmin> logAdminOptional = logAdminService.findByAdminUser(adminUser);
            
            // Jika username tidak ditemukan
            if (logAdminOptional.isEmpty()) {
                model.addAttribute("errorMessage", "Username tidak ditemukan!");
            } else {
                model.addAttribute("errorMessage", "Password salah!");
            }

            // Kembalikan ke halaman login dengan pesan kesalahan
            return "LogAdmin"; // Nama file HTML untuk halaman login
        }
    }

    @PostMapping("/berandaAdmin")
    public String berandaAdmin() {
        return "berandaAdmin"; // Nama file template Thymeleaf atau file HTML
    }

    // Endpoint untuk menampilkan daftar nasabah
    @GetMapping("/nasabahlist")
    public String getNasabahList(Model model) {
        // Mengambil semua data nasabah
        List<LogNasabah> nasabahList = logNasabahRepository.findAll();
        
        // Menambahkan data ke model untuk Thymeleaf
        model.addAttribute("nasabahList", nasabahList);
        return "nasabahlist"; // Mengembalikan file nasabahlist.html
    }

    // Endpoint untuk menghapus nasabah berdasarkan ID
    @PostMapping("/nasabah/hapus/{id}")
    public String hapusNasabah(@PathVariable("id") Integer id) {
        logNasabahRepository.deleteById(id);
        return "redirect:/admin/nasabahlist"; // Redirect setelah penghapusan
    }
}
