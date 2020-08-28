package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

/**
 * exception vérifiant la soustraction de la tare au poids de la palette
 * le résultat ne peut pas être négatif
 */
public class SubAboveZeroFalseException extends Exception{
    public SubAboveZeroFalseException(){
        super(ConstantesUtil.getProperty(Constantes.EXCEPTION_SUB_ABOVE_ZERO));
    }
}
