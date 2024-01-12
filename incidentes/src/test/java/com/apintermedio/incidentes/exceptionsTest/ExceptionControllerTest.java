package com.apintermedio.incidentes.exceptionsTest;

import com.apintermedio.incidentes.exception.ClienteNotFoundException;
import com.apintermedio.incidentes.exception.ExceptionController;
import com.apintermedio.incidentes.responseDto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionControllerTest {
    //no tengo inxeccion de dependencias por eso no se usa el mock
    @Autowired
    ExceptionController exceptionController;

    @Test
    @DisplayName ( "Test camino feliz nofoundexception" )
            void ClienteNotFoundTest() {
        //arrange
        ErrorDto body = new ErrorDto ( 404, "mensaje" );

        ClienteNotFoundException argumentoSut = new ClienteNotFoundException ( "mensaje" );
        ResponseEntity<?> expected = new ResponseEntity<> ( body, HttpStatus.NOT_FOUND );

        //act
        ResponseEntity<?>actual = exceptionController.clienteNotFound ( argumentoSut );

        //assert
        assertEquals(expected,actual);

    }



}
