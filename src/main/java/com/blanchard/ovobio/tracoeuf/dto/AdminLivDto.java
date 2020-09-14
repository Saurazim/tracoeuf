package com.blanchard.ovobio.tracoeuf.dto;

public class AdminLivDto {
    private int id;
    private String date;
    private String fournisseur;
    private String categorie;
    private Integer nbPalette;
    private String prefix;
    private Integer netTotal;
    private String bonLivraison;

    public AdminLivDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getNbPalette() {
        return nbPalette;
    }

    public void setNbPalette(Integer nbPalette) {
        this.nbPalette = nbPalette;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Integer netTotal) {
        this.netTotal = netTotal;
    }

    public String getBonLivraison() {
        return bonLivraison;
    }

    public void setBonLivraison(String bonLivraison) {
        this.bonLivraison = bonLivraison;
    }
}
