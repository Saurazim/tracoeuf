package com.blanchard.ovobio.tracoeuf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO exception test
 * sert de référence
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {
    public ProduitIntrouvableException(String s) {
        super(s);
    }
}
