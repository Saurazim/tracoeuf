package com.blanchard.ovobio.tracoeuf.bo;

public class LivraisonBo {
    private int id;
    private String date;
    private int fournisseurId;
    private int categorieId;
    private Integer netTotal;
    private String prefix;
    private Integer compte;


    public LivraisonBo() {
    }

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

    public int getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(int fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public Integer getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Integer netTotal) {
        this.netTotal = netTotal;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getCompte() {
        return compte;
    }

    public void setCompte(Integer compte) {
        this.compte = compte;
    }
}
