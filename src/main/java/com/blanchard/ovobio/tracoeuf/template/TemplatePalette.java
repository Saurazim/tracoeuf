package com.blanchard.ovobio.tracoeuf.template;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import com.blanchard.ovobio.tracoeuf.util.FormUtil;

import java.time.LocalDate;

public class TemplatePalette {
    private String reference;
    private String date;
    private String nom;

    private static final String extension = ConstantesUtil.getProperty(ConstExt.EXTENSION_ETIQUETTE_PALETTE);

    public TemplatePalette(String reference, String date) {
        this.reference = reference;
        this.date = date;
    }

    public TemplatePalette(String reference, LocalDate date) {
        this.reference = reference;
        this.setDate(date);
        this.nom=reference+date.toString()+extension;

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

    public void setDate(LocalDate date){
        this.date = FormUtil.dateToString(date);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNom(String reference, LocalDate date){
        this.nom = reference+date.toString()+extension;
    }
}
