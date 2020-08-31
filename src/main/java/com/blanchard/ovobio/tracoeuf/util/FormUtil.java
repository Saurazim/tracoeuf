package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * interface pour la validation de valeurs
 */
public interface FormUtil {
    static final String DATE_FORMAT = ConstantesUtil.getProperty(Constantes.PATTERN);

    static boolean isNull(Object object){
        if (object == null)
            return true;
        else
            return false;
    }

    static String dateToString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
