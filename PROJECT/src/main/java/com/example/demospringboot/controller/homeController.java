package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class homeController {

    // Endpoint untuk menampilkan halaman home
    @GetMapping("/")
    public String home() {
        return "home";  // Mengembalikan nama template 'home.html'
    }

    // Endpoint untuk halaman LogNasabah
    @GetMapping("/LogNasabah")
    public String logNasabah() {
        return "LogNasabah";  // Mengembalikan nama template 'LogNasabah.html'
    }

    // Endpoint untuk halaman LogAdmin
    @GetMapping("/LogAdmin")
    public String logAdmin() {
        return "LogAdmin";  // Mengembalikan nama template 'LogAdmin.html'
    }

    // Endpoint untuk halaman Signup
    @GetMapping("/Signup")
    public String signup() {
        return "Signup";  // Mengembalikan nama template 'Signup.html'
    }

    @GetMapping("/beranda")
	public String beranda(){
		return "beranda";
	}

    @GetMapping("/dataDiri")
	public String dataDiri(){
		return "dataDiri";
	}

    @GetMapping("/infopinjamNas")
	public String infopinjamNas(){
		return "infopinjamNas";
	}

    @GetMapping("/berandaAdmin")
    public String berandaAdmin() {
        return "berandaAdmin"; // Nama file template Thymeleaf atau file HTML
    }

    @GetMapping("/nasabahlist")
	public String nasabahlist(){
		return "nasabahlist";
	}
    
}
