package com.api.instrumentosmusicais.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "verified")
    private Boolean verified = false;

    @Column(name = "created_at")
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());


    @Column(name = "updated_at")
    private Timestamp updatedAt = Timestamp.valueOf(LocalDateTime.now());;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

}
