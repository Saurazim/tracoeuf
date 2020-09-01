package com.blanchard.ovobio.tracoeuf.backup;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * dto du formulaire
 * 1 dto = 1 palette de livraison
 * @backup
 * @deprecated
 */
public class LivraisonDto {
    private Integer idColumn = ConstInt.ZERO;
    private String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String idFournisseur= ConstInt.FOURNISSEUR_ID_DEFAULT.toString();
    private String autreFournisseur;
    private Integer idCategorie=ConstInt.CATEGORIE_TYPE_ID_BIO;
    private Integer poidsPalette;
    private Boolean typePoids;
    private Integer tareNbAlveole=ConstInt.TARE_NB_ALVEOLE_DEFAULT;
    private String tareTypePalette=ConstInt.TARE_TYPE_PLASTIQUE;
    private Integer nbTare;
    private Boolean checkTare = ConstantesUtil.getPropertyToBool(ConstExt.CHECK_TARE);

    public LivraisonDto(){}

    public Integer getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(Integer idColum) {
        this.idColumn = idColum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getAutreFournisseur() {
        return autreFournisseur;
    }

    public void setAutreFournisseur(String autre_fournisseur) {
        this.autreFournisseur = autre_fournisseur;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getPoidsPalette() {
        return poidsPalette;
    }

    public void setPoidsPalette(Integer poidsPalette) {
        this.poidsPalette = poidsPalette;
    }

    public Boolean getTypePoids() {
        return typePoids;
    }

    public void setTypePoids(Boolean typePoids) {
        this.typePoids = typePoids;
    }

    public Integer getTareNbAlveole() {
        return tareNbAlveole;
    }

    public void setTareNbAlveole(Integer tareNbAlveole) {
        this.tareNbAlveole = tareNbAlveole;
    }

    public String getTareTypePalette() {
        return tareTypePalette;
    }

    public void setTareTypePalette(String tareTypePalette) {
        this.tareTypePalette = tareTypePalette;
    }

    public Integer getNbTare() {
        return nbTare;
    }

    public void setNbTare(Integer tare) {
        this.nbTare = tare;
    }

    public Boolean getCheckTare() {
        return checkTare;
    }

    public void setCheckTare(Boolean checkTare) {
        this.checkTare = checkTare;
    }
}
