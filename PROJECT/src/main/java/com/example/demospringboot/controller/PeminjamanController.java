package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demospringboot.service.PeminjamanService;

@Controller
public class PeminjamanController {

@Autowired
private PeminjamanService peminjamanService;
    
    @GetMapping("/peminjaman")
    public String showPeminjaman(
            @RequestParam(value = "duration", required = false) String duration,
            @RequestParam(value = "interest", required = false) String interest,
            Model model) {
        
        if (duration != null) {
            model.addAttribute("duration", duration);
        }
        if (interest != null) {
            model.addAttribute("interest", interest);
        }
        return "peminjaman";
    }

    @PostMapping("/submitPeminjaman")
    public String submitPeminjaman(
            @RequestParam("duration") String duration,
            @RequestParam("interest") String interest,
            @RequestParam("amount") Double amount,
            Model model) {
                
    //INI BUAT SIMPEN NOMINAL DI DATABASE
            // Panggil service untuk menyimpan data
    Double persen = Double.parseDouble(interest.replace("%", ""));
    peminjamanService.savePeminjaman(amount, duration, persen);

                // Proses peminjaman
        return "redirect:/pembayaran";  // atau halaman sukses lainnya
    }
}