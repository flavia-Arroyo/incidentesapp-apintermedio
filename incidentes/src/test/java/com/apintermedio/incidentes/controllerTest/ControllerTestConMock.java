package com.apintermedio.incidentes.controllerTest;

import com.apintermedio.incidentes.controller.ClienteController;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import com.apintermedio.incidentes.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import static com.apintermedio.incidentes.utils.ClienteUtils.unClienteDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerTestConMock {
    @Mock

    ClienteService service;

    @InjectMocks
    ClienteController controller;

    @Test
    void agregarClienteOkTest(){
       //arrange
        ClienteDto argumentoSut = unClienteDto();
        ResponseClienteDto body = new ResponseClienteDto ( argumentoSut, "mje random" );

        ResponseEntity<?> expected = new ResponseEntity<> ( body, HttpStatus.OK );

        when(service.guardarCliente ( any() )).thenReturn(new ResponseClienteDto ( argumentoSut, "mje random" ));

        //ACT
        ResponseEntity<?> actual = controller.crearCliente ( argumentoSut );
          //assert
        assertEquals(expected,actual);






    }

}
