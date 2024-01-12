package com.apintermedio.incidentes.serviceTest;

import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.requestDto.ServDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import com.apintermedio.incidentes.service.IClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTestSinMock {
    //instancia cliente service
    @Autowired
    IClienteService clienteServ;

    @Test
    @DisplayName ( "Test guardar cliente sobre camino feliz" )
    void guardarClienteOkTest() {
        //ARRANGE
        ServDto argSutServ = new ServDto ( 5L, "aplicaciones" );
        ServDto argSutServ2 = new ServDto ( 6L, "soporte tecnico" );
        Set<ServDto> listServ = new HashSet<> ( );
        listServ.add ( argSutServ );
        listServ.add ( argSutServ2 );
        ClienteDto argumentoSut = new ClienteDto ( "Comodin SRL",
                "30-54321304-9", "Comodoro 1243", "conodursrl@gmail.com", listServ );

        ResponseClienteDto expected = new ResponseClienteDto ( argumentoSut, "Se guardo correctamente" );

        //act
        ResponseClienteDto actual = clienteServ.guardarCliente ( argumentoSut );
        //assert
        assertEquals(expected,actual);


    }

    }

    //arrangs el primer paso de los test unitarios(parametros y objetos

    //act paso intermedio es la llamada del metodo que quiero probar

    //assert confirmamos que el rtado del metodo sea lo esperado




