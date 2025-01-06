package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demospringboot.entity.Pembayaran;
import com.example.demospringboot.service.PembayaranService;
import java.util.Map;

@Controller
public class PembayaranController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PembayaranService pembayaranService;
    
    @GetMapping("/pembayaran")
    public String showPembayaran(
            @RequestParam(value = "duration", required = false) String duration,
            Model model) {
        
        if (duration != null) {
            model.addAttribute("duration", duration);
        }
        
        // Mengambil total_pinjaman terakhir dari database
        String sql = "SELECT idpeminjaman, total_pinjaman FROM peminjaman ORDER BY idpeminjaman DESC LIMIT 1";
        String sqlPembayaran = "SELECT idpembayaran FROM pembayaran ORDER BY idpembayaran DESC LIMIT 1";
        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(sql);
            Map<String, Object> pembayaranResult = jdbcTemplate.queryForMap(sqlPembayaran);
           
            Double totalPinjaman = ((Number) result.get("total_pinjaman")).doubleValue();
            Integer idpeminjaman = ((Number) result.get("idpeminjaman")).intValue();
            Integer idpembayaran = ((Number) pembayaranResult.get("idpembayaran")).intValue();
            
            model.addAttribute("totalPinjaman", totalPinjaman);
            model.addAttribute("idpeminjaman", idpeminjaman);
            model.addAttribute("idpembayaran", idpembayaran);
        } catch (Exception e) {
            model.addAttribute("totalPinjaman", 0.0);
            model.addAttribute("idpeminjaman", 0);
            model.addAttribute("idpembayaran", 0);
        }
        
        return "pembayaran";
    }

    @PostMapping("/submitPembayaran")
    public String submitPembayaran(
            @RequestParam("duration") String duration,
            @RequestParam(value = "nomorPembayaran", required = false) String nomorPembayaran,
            @RequestParam("nominal") Double nominal,
            @RequestParam("paymentMethod") String paymentMethod,
            @RequestParam("idpeminjaman") Integer idpeminjaman,
            Model model) {
        
        try {
            Pembayaran pembayaran = new Pembayaran();
            pembayaran.setNominal(nominal);
            pembayaranService.savePembayaran(nominal,paymentMethod,idpeminjaman);
            return "redirect:/pembayaran?success";
        } catch (Exception e) {
            return "redirect:/pembayaran?error";
        }
    }
}
