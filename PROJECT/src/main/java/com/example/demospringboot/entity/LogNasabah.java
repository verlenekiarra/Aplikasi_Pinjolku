package com.example.demospringboot.entity;

// import com.example.demospringboot.entity.AbstractUser;
import jakarta.persistence.*;

@Entity
@Table(name = "lognasabah")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "nasabah_id")),
    @AttributeOverride(name = "username", column = @Column(name = "nasabah_user")),
    @AttributeOverride(name = "password", column = @Column(name = "nasabah_pass"))
})
public class LogNasabah extends AbstractUser {
    
    // Getter dan Setter untuk kompatibilitas dengan kode yang sudah ada
    public Integer getNasabahId() {
        return getId();
    }

    public void setNasabahId(Integer nasabahId) {
        setId(nasabahId);
    }

    public String getNasabahUser() {
        return getUsername();
    }

    public void setNasabahUser(String nasabahUser) {
        setUsername(nasabahUser);
    }

    public String getNasabahPass() {
        return getPassword();
    }

    public void setNasabahPass(String nasabahPass) {
        setPassword(nasabahPass);
    }
}