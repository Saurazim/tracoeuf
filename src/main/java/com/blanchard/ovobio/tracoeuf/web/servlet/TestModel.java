package com.blanchard.ovobio.tracoeuf.web.servlet;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "utilisateur")
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String motDePasse;
    @Column(name = "nom")
    private String nomUtilisateur;
    private LocalDateTime dateInscription;

    public TestModel(){}

    public TestModel(String email, String motDePasse, String nomUtilisateur, LocalDateTime dateInscription) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.nomUtilisateur = nomUtilisateur;
        this.dateInscription = dateInscription;
    }

    public TestModel(String email, String motDePasse, String nomUtilisateur) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }
}
