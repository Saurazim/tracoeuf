package com.blanchard.ovobio.tracoeuf.util;

import com.blanchard.ovobio.tracoeuf.configuration.Configurations;
import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;

/**
 * interface pour récupérer les valeurs constantes de constantes.properties
 * @see ConstExt
 */
public interface ConstantesUtil {

    /**
     * avoir rapidement la valeur de la constante
     * @param key clé de la constante
     * @return valeur de la constante
     */
    static String getProperty(String key){
        return Configurations.getInstance().getProperty(key);
    }

    /**
     * avoir rapidement la valeur de la constante si c'est un entier
     * @param key la clé
     * @return la valeur
     */
    static int getPropertyToInt(String key){
        String property = Configurations.getInstance().getProperty(key);
        return Integer.parseInt(property);
    }

    /**
     * avoir rapidement la valeur de la constante si c'est un booléen
     * @param key la clé
     * @return la valeur
     */
    static boolean getPropertyToBool(String key){
        String property = Configurations.getInstance().getProperty(key);
        return Boolean.parseBoolean(property);
    }
}
