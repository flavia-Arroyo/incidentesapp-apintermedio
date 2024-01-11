package com.apintermedio.incidentes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.NOT_FOUND , reason="el cliente no fue encontrado")
public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String message) {
        super ( message );
    }
}
