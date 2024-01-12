package com.apintermedio.incidentes.serviceTest;

import com.apintermedio.incidentes.controller.ClienteController;
import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.repository.IClienteRepository;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import com.apintermedio.incidentes.service.ClienteService;
import com.apintermedio.incidentes.utils.ClienteUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.apintermedio.incidentes.utils.ClienteUtils.unClienteDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTestConMock {
    //SE USA PARA CLASES DEL SERVICE Y DEL CONTROLLER
    //se recrea el repositorio

    @Mock
    IClienteRepository cliRepo;

    @InjectMocks
    ClienteService cliServ;

    @Test
    void guardarClienteOkTest(){
        //arrange
        /* cliArg = unClienteDto();
        ResponseClienteDto expected = new ResponseClienteDto ( cliArg, "Se guardo correctamente" );
        Servicios serv = new Servicios( 5L , "aplicaciones" , );


        Cliente c = new Cliente ( 13L, "Comodin SRL",
                "30-54321304-9", "Comodoro 1243", "conodursrl@gmail.com", serv )

        when(cliRepo.crearCliente( any ())).thenReturn ( c );*/

    }

}
