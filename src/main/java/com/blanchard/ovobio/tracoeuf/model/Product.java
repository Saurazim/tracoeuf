package com.blanchard.ovobio.tracoeuf.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * TODO entity test
 * sert de référence
 */
@Entity
//@JsonIgnoreProperties(value = {"prixAchat", "id"})
//@JsonFilter("monFiltreDynamique")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Length(min=3, max=20, message = "mon message d'erreur")
    private String nom;

    @Min(1)
    private int prix;

    //info à cacher
    //@JsonIgnore
    private int prixAchat;

    public Product() {}

    public Product(int id, String nom, int prix, int prixAchat) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixAchat = prixAchat;
    }
    /**
     * Getters et setters
     * */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * fonction toString auto-générée
     * @return Entity Product in String
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
