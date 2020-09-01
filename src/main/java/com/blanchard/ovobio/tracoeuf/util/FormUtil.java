package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * interface pour la validation de valeurs
 */
public interface FormUtil {
    String DATE_FORMAT = ConstantesUtil.getProperty(ConstExt.PATTERN);

    static boolean isNull(Object object){
        return (object==null);
    }

    static String dateToString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
