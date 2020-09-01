package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;

import java.time.LocalDate;

/**
 * ensemble de fonctions pouvant servir à l'élaboration du code de livraison
 * @see com.blanchard.ovobio.tracoeuf.service.LivraisonService
 * @deprecated
 */
public interface CodeLivUtil {
    int CFL = ConstantesUtil.getPropertyToInt(ConstExt.CODE_FOURNISSEUR_LONGUEUR);

    /**
     * @deprecated la date n'entre plus dans la composition du code
     * @param date de la livraison
     * @return code de la date
     */
    static int getDateCode(LocalDate date){
        String year = String.valueOf(date.getYear());
        String codeTmp = year.substring(year.length() - 2)+date.getDayOfYear();
        return Integer.parseInt(codeTmp);
    }

    /**
     * @deprecated est enregistré dans l'objet fournisseur et en bdd
     * @param nom le nom du fournisseur
     * @return le code
     */
    static String getFournisseurCode(String nom){
        String codeTmp;
        if (nom.length()>CFL)
            codeTmp = nom.substring(0,CFL);
        else
            codeTmp = nom;
        return codeTmp.toUpperCase();
    }

}
