package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Peminjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpeminjaman;
    private Double persen;
    private Double nominal;

    //Tambahan totalpinjaman
    private Double totalPinjaman;

    @OneToOne
    private InfoPeminjaman infoPeminjaman;  // FK to InfoPeminjaman

    // Getter and Setter for idpeminjaman
    public Integer getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setPersen(Double persen){
        this.persen = persen;
    }

    public Double getPersen(){
        return persen;
    }

    public void setIdpeminjaman(Integer idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    // Getter and Setter for nominal
    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    // Getter and Setter for infoPeminjaman
    public InfoPeminjaman getInfoPeminjaman() {
        return infoPeminjaman;
    }

    public void setInfoPeminjaman(InfoPeminjaman infoPeminjaman) {
        this.infoPeminjaman = infoPeminjaman;
    }

    // Getter dan Setter untuk totalPinjaman
    public Double getTotalPinjaman() {
        return totalPinjaman;
    }

    public void setTotalPinjaman(Double totalPinjaman) {
        this.totalPinjaman = totalPinjaman;
    }
}
