package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "datadiri")
public class dataDiri {

    // Variables - menggunakan camelCase sesuai konvensi Java
    @Id
    private String nik;  // Primary Key
    private String norek;
    private String nama;
    private String email;
    private String alamat;
    private String telp;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lahir;

    // Default Constructor
    public dataDiri() {
    }

    // Constructor dengan parameter
    public dataDiri(String nik, String nama, String email, String alamat, String telp, Date lahir, String norek) {
        this.nik = nik;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.telp = telp;
        this.lahir = lahir;
        this.norek=norek;
    }

    // Getter dan Setter
    public String getnik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getnorek() {
        return norek;
    }

    public void setnorek(String norek) {
        this.norek = norek;
    }

    public String getnama() {
        return nama;
    }

    public void setnama(String nama) {
        this.nama = nama;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getalamat() {
        return alamat;
    }

    public void setalamat(String alamat) {
        this.alamat = alamat;
    }

    public String gettelp() {
        return telp;
    }

    public void settelp(String telp) {
        this.telp = telp;
    }

    public Date getlahir() {
        return lahir;
    }

    public void setlahir(Date lahir) {
        this.lahir = lahir;
    }

    // Override toString method untuk debugging
    @Override
    public String toString() {
        return "dataDiri{" +
                "nik='" + nik + '\'' +
                ", nama Lengkap='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", alamat='" + alamat + '\'' +
                ", no Telp='" + telp + '\'' +
                ", tgl lahir=" + lahir +
                '}';
    }
}