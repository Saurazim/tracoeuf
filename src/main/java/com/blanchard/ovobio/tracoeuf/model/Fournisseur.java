package com.blanchard.ovobio.tracoeuf.model;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * fournisseur d'oeufs
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String code;

    public Fournisseur(){}

    public Fournisseur(String nom){
        this.nom = nom;
    }

    public Fournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}