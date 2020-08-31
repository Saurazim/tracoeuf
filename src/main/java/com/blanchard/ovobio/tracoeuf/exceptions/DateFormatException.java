package com.blanchard.ovobio.tracoeuf.exceptions;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class DateFormatException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DateFormatException() {
        super(ConstantesUtil.getProperty(Constantes.EXCEPTION_DATE_FORMAT));
    }
}
