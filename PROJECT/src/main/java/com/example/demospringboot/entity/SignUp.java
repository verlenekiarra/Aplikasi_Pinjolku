package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "signUp")
public class SignUp {  // Tidak abstrak, karena harus konkret untuk JPA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer signId;  // Auto-generated, tipe data Integer

    private String signUser;
    private String signPass;

    // Konstruktor default
    public SignUp() {
    }

    // Konstruktor dengan parameter
    public SignUp(String signUser, String signPass) {
        this.signUser = signUser;
        this.signPass = signPass;
    }

    // Getter dan Setter
    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public String getSignUser() {
        return signUser;
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser;
    }

    public String getSignPass() {
        return signPass;
    }

    public void setSignPass(String signPass) {
        this.signPass = signPass;
    }

}
