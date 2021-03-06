package com.blanchard.ovobio.tracoeuf.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * objet livraison
 * correspond à une date, un fournisseur, une catégorie
 *
 * plusieurs livraison peuvent provenir d'un même chargement et d'un même fournisseur,
 * mais d'une catégorie différente.
 *
 * une livraison est liée à une catégorie et un fournisseur
 */
@Entity
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "FournisseurId", nullable = false)
    private Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name = "CategorieId", nullable = false)
    private Categorie categorie;
    private Integer netTotal;
    private String prefixCode;
    private Integer compte;
    private String bonLivraison;
    @Transient
    private List<Palette> palettes = new ArrayList<>();

    public Livraison() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Integer netTotal) {
        this.netTotal = netTotal;
    }

    public List<Palette> getPalettes() {
        return palettes;
    }

    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }

    public void addtoPalettes(Palette palette){
        palette.setLivraison(this);
        this.palettes.add(palette);
    }

    public String getPrefixCode() {
        return prefixCode;
    }

    public void setPrefixCode(String prefixCode) {
        this.prefixCode = prefixCode;
    }

    public Integer getCompte() {
        return compte;
    }

    public void setCompte(Integer compte) {
        this.compte = compte;
    }

    public String getBonLivraison() {
        return bonLivraison;
    }

    public void setBonLivraison(String bonLivraison) {
        this.bonLivraison = bonLivraison;
    }
}
