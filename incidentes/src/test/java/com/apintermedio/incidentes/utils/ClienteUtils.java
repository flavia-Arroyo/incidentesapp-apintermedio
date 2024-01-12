package com.apintermedio.incidentes.utils;

import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.requestDto.ServDto;

import java.util.List;
import java.util.Set;

import static com.apintermedio.incidentes.utils.ServicioUtils.ListaServicioDto;

public class ClienteUtils {
    public static ClienteDto unClienteDto(){
        Set<ServDto> listServ = ListaServicioDto();

        ClienteDto cli =  new ClienteDto ( "Comodin SRL",
                "30-54321304-9", "Comodoro 1243",
                "conodursrl@gmail.com",  listServ );


        return  cli;
    };
}
