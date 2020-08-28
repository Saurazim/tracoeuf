package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class IntExpectedException extends Exception{
    public IntExpectedException(String champ){
        super(ConstantesUtil.getProperty(Constantes.EXCEPTION_CHAMP_INT_EXPECTED_STRING)+champ);
    }

    public IntExpectedException(){
        super(ConstantesUtil.getProperty(Constantes.EXCEPTION_CHAMP_INT_EXPECTED));
    }
}
