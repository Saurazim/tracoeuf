package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.exceptions.ChampVideException;
import com.blanchard.ovobio.tracoeuf.exceptions.IntExpectedException;
import com.blanchard.ovobio.tracoeuf.exceptions.SubAboveZeroFalseException;
import com.blanchard.ovobio.tracoeuf.service.Validation;

/**
 * interface d'expressions et de traitements mathématiques
 */
public interface MathsUtil {
    /**
     * Soustrait l'entier 2 à l'entier 1 et retourne une erreur si le résultat est négatif
     * @param int1 un entier
     * @param int2 l'entier soustrait à int1
     * @return le résultat de la soustraction
     * @throws SubAboveZeroFalseException si résultat négatif
     */
    static Integer subAboveZero(Integer int1, Integer int2) throws SubAboveZeroFalseException{
        Integer result = int1 - int2;
        if (result<0){
            throw new SubAboveZeroFalseException();
        }
        return result;
    }

    static Integer subWithCheck(String str1, String str2) throws ChampVideException, IntExpectedException, SubAboveZeroFalseException {
        Integer resultat = 0;
        try{
            Validation.checkInt(str1);
            Validation.checkInt(str2);
        }catch (Exception e){
            throw e;
        }

        try{
            resultat = subAboveZero(Integer.parseInt(str1),Integer.parseInt(str2));
        } catch (SubAboveZeroFalseException e){
            throw e;
        }
        return resultat;
    }


}
