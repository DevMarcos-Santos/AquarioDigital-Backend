package com.project.peixelandia.domain.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "bio")
    private String Bio;

    @Column(name = "fotoPerfil")
    private String FotoPerfil;

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        FotoPerfil = fotoPerfil;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users UserId;

    public Users getUserId() {
        return UserId;
    }

    public void setUserId(Users userId) {
        UserId = userId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }
}
