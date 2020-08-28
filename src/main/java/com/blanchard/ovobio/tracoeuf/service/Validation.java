package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.bo.TareBo;
import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import com.blanchard.ovobio.tracoeuf.util.FormUtil;

/**
 * interface de validation des données formulaires
 */
public interface Validation {

    static void checkVideString(String champ, String exception) throws Exception {
        if (FormUtil.isNull(champ) || champ.isEmpty())
            throw new Exception(exception);
    }

    static boolean checkPoids(Integer champ, String exceptionVide, String exceptionNonInt) throws Exception {
        if (FormUtil.isNull(champ) || champ.equals("")) {
            throw new Exception(exceptionVide);}
        return true;
    }

    static void checkDate(String champDate, String exceptionVide, String ExceptionFormat) throws Exception{
        if (FormUtil.isNull(champDate)){
            throw new Exception(exceptionVide);
        } else {
            if (!champDate.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")){
                throw new Exception(ExceptionFormat);
            }
        }
    }

    /**
     * check la valeur de la tare et renvoie la valeur final
     * @param tareBo
     * @return
     * @throws Exception si check et autre tare vide
     */
    static void checkTare(TareBo tareBo) throws Exception{
        int intTare = 10;
        if (tareBo.getCheckTare()){
            checkInt(tareBo.getTare(), ConstantesUtil.getProperty(Constantes.EXC_TARE_VIDE));
            intTare = tareBo.getTare();
        }else{
            intTare = getTareBySC(tareBo.getTareNbAlveole(), tareBo.getTareTypePalette());
        }
        tareBo.setTareFinal(intTare);
    }



    /**
     * get tare par table des tares
     * @param nbAlveole
     * @param typePalette
     * @return
     */
    private static int getTareBySC(Integer nbAlveole, String typePalette) {//TODO créer table des tares
        int tare = 10;
        if(ConstantesUtil.getProperty(Constantes.TARE_TYPE_PLASTIQUE).equals(typePalette)){
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

    static void checkInt(Integer champ, String exceptionVide) throws Exception {
        if (FormUtil.isNull(champ) || champ.equals("")) {
            throw new Exception(exceptionVide);}
    }
}