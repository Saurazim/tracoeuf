package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.exceptions.SubAboveZeroFalseException;

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


}
