package com.example.demospringboot.controller;

import com.example.demospringboot.entity.dataDiri;
import com.example.demospringboot.service.dataDiriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class dataDiriController {

    @Autowired
    private dataDiriService dataDiriService;

    // Menyimpan data diri ke database
    @PostMapping("/datadiri/save")
    public String saveDataDiri(@ModelAttribute dataDiri dataDiri) {
        dataDiriService.saveDataDiri(dataDiri);
        return "redirect:/infopinjamNas"; // Redirect ke halaman sukses atau tujuan lain
    }
}
