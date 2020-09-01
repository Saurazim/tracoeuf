package com.blanchard.ovobio.tracoeuf.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * dto du formulaire
 * 1 dto = 1 palette de livraison
 */
public class LivraisonDto {
    private String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String fournisseurId;
    private String fournisseurAutre;
    private Integer categorieId;
    private Integer nombrePalette = 1;

    public LivraisonDto(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(String fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getFournisseurAutre() {
        return fournisseurAutre;
    }

    public void setFournisseurAutre(String fournisseurAutre) {
        this.fournisseurAutre = fournisseurAutre;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public Integer getNombrePalette() {
        return nombrePalette;
    }

    public void setNombrePalette(Integer nombrePalette) {
        this.nombrePalette = nombrePalette;
    }
}
