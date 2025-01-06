package com.example.demospringboot.entity;

// import com.example.demospringboot.entity.AbstractUser;
import jakarta.persistence.*;

@Entity
@Table(name = "logadmin")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "admin_id")),
    @AttributeOverride(name = "username", column = @Column(name = "admin_user")),
    @AttributeOverride(name = "password", column = @Column(name = "admin_pass"))
})
public class LogAdmin extends AbstractUser {
    
    // Getter dan Setter untuk kompatibilitas dengan kode yang sudah ada
    public Integer getadminId() {
        return getId();
    }

    public void setadminId(Integer adminId) {
        setId(adminId);
    }

    public String getadminUser() {
        return getUsername();
    }

    public void setadminUser(String adminUser) {
        setUsername(adminUser);
    }

    public String getadminPass() {
        return getPassword();
    }

    public void setadminPass(String adminPass) {
        setPassword(adminPass);
    }
}