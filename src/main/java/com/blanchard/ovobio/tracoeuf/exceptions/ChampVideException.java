package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class ChampVideException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ChampVideException(String champ) {
        super(ConstantesUtil.getProperty(ConstExt.EXCEPTION_CHAMP_VIDE_STRING) + champ);
    }
    public ChampVideException(){super(ConstantesUtil.getProperty(ConstExt.EXCEPTION_CHAMP_VIDE));}
}
