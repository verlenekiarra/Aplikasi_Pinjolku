package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pembayaran")
public class Pembayaran {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpembayaran;
    
    // private String nomorPembayaran;
    @Column(name = "nominal")
    private Double nominal;

    @Column(name = "metode_pembayaran")
    private String metodePembayaran;

     @OneToOne
     @JoinColumn(name = "idpeminjaman", referencedColumnName = "idpeminjaman", nullable = true)
    private Peminjaman peminjaman;  // FK to Peminjaman

    // Getters and Setters
    public Integer getIdPembayaran() {
        return idpembayaran;
    }

    public void setId(Integer idpembayaran) {
        this.idpembayaran = idpembayaran;
    }

    public void setTenor(String duration) {
        throw new UnsupportedOperationException("Unimplemented method 'setTenor'");
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    // Getter and Setter for idpeminjaman
    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }
}