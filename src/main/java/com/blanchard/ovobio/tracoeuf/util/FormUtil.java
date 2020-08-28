package com.blanchard.ovobio.tracoeuf.util;

/**
 * interface pour la validation de valeurs
 */
public interface FormUtil {
    static boolean isNull(Object object){
        if (object == null)
            return true;
        else
            return false;
    }
}
