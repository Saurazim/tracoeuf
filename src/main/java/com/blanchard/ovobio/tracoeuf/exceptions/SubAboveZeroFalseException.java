package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

/**
 * exception vérifiant la soustraction de la tare au poids de la palette
 * le résultat ne peut pas être négatif
 */
public class SubAboveZeroFalseException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SubAboveZeroFalseException() {
        super(ConstantesUtil.getProperty(ConstExt.EXCEPTION_SUB_ABOVE_ZERO));
    }
}
