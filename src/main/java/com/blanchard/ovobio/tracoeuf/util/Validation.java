package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.bo.TareBo;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.exceptions.ChampVideException;
import com.blanchard.ovobio.tracoeuf.exceptions.DateFormatException;
import com.blanchard.ovobio.tracoeuf.exceptions.IntExpectedException;

/**
 * interface de validation des données formulaires
 */
public interface Validation {

    static void checkValeurVide(String valeur, String champ) throws ChampVideException {
        if (valeur.isBlank())
            throw new ChampVideException(champ);
    }

    static void checkValeurVide(String valeur) throws ChampVideException {
        if (valeur.isBlank())
            throw new ChampVideException();
    }

    static void checkValeurVide(Integer valeur, String champ) throws ChampVideException {
        if (valeur==null) {
            throw new ChampVideException(champ);
        }
    }

    static void checkValeurVide(Integer valeur) throws ChampVideException {
        if (valeur==null) {
            throw new ChampVideException();
        }
    }

    static void checkDate(String date, String champDate) throws ChampVideException, DateFormatException {
        checkValeurVide(date,champDate);
        if (!date.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")){
            throw new DateFormatException();
        }
    }

    /**
     * check la valeur de la tare et renvoie la valeur final
     * @param tareBo objet tare
     * @throws Exception si check et autre tare vide
     */
    static void checkTare(TareBo tareBo) throws Exception{
        int intTare = 10;
        if (tareBo.getCheckTare()){
            checkInt(tareBo.getTare().toString());
            intTare = tareBo.getTare();
        }else{
            try {
                intTare = getTareBySC(tareBo.getTareNbAlveole(), tareBo.getTareTypePalette());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        tareBo.setTareFinal(intTare);
    }



    /**
     * get tare par table des tares
     * @param nbAlveole nb d'alvéole d'un étage
     * @param typePalette type de la matière
     * @return une tare en kg
     */
    private static int getTareBySC(Integer nbAlveole, String typePalette) {//TODO créer table des tares
        int tare = 10;
        if(ConstInt.TARE_TYPE_PLASTIQUE.equals(typePalette)){
            switch (nbAlveole){
                case 5:
                    tare=78;
                    break;
                case 4:
                    tare=70;
                default:break;
            }
        }else {
            switch (nbAlveole){
                case 5:
                    tare=58;
                    break;
                case 4:
                    tare=50;
                    break;
                case 3:
                    tare=42;
                    break;
                case 2:
                    tare=34;
                    break;
                case 1:
                    tare=26;
                default:break;
            }
        }
        return tare;
    }

    static void checkInt(String valeur) throws ChampVideException, IntExpectedException {
        checkValeurVide(valeur);
        try{
            Integer.parseInt(valeur);
        } catch (Exception e){
            throw new IntExpectedException();
        }
    }

    static void checkInt(String valeur, String champ) throws ChampVideException, IntExpectedException {
        checkValeurVide(valeur, champ);
        try{
            Integer.parseInt(valeur);
        } catch (Exception e){
            throw new IntExpectedException(champ);
        }
    }
}
