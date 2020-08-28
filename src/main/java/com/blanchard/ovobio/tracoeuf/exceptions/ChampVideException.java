package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class ChampVideException extends Exception{
    public ChampVideException(String champ){super(ConstantesUtil.getProperty(Constantes.EXCEPTION_CHAMP_VIDE_STRING)+champ);}
    public ChampVideException(){super(ConstantesUtil.getProperty(Constantes.EXCEPTION_CHAMP_VIDE));}
}
