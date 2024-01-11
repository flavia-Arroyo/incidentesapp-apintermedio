package com.apintermedio.incidentes.exception;

import com.apintermedio.incidentes.responseDto.ErrorDto;
import com.apintermedio.incidentes.responseDto.ErrorValidationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<?> clienteNotFound(ClienteNotFoundException ex){
        ErrorDto err = new ErrorDto ( 404,ex.getMessage () );
        return new ResponseEntity<> ( err, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler (InsertionDbException.class)
    public ResponseEntity<?> insercionIncorrecta(InsertionDbException ex){
        ErrorDto err = new ErrorDto ( 400, ex.getMessage () );
        return new ResponseEntity<> ( err, HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler(ClonException.class)
    public ResponseEntity<?> clonException (ClonException ex){
        ErrorDto err = new ErrorDto ( 400, ex.getMessage () );
        return new ResponseEntity<> ( err, HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> fallaValidacion(MethodArgumentNotValidException ex){
        HashMap<String, String> errores = new HashMap<> ();
        ex.getFieldErrors ()
                .forEach (field -> errores.put( field.getField ( ), field.getDefaultMessage ()));


        return new ResponseEntity<> ( new ErrorValidationDto ( 400, errores ), HttpStatus.BAD_REQUEST );

    }
}
