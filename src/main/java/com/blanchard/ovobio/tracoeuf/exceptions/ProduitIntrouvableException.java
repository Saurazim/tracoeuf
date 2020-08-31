package com.blanchard.ovobio.tracoeuf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO exception test
 * sert de référence
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ProduitIntrouvableException(String s) {
        super(s);
    }
}
