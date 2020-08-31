package com.blanchard.ovobio.tracoeuf.template;

public class TemplatePalette {
    private String reference;
    private String date;
    private String nom;

    public TemplatePalette(String reference, String date) {
        this.reference = reference;
        this.date = date;
        this.nom = date+reference+".docx";
    }

    public String getRef() {
        return reference;
    }

    public void setRef(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
