package com.apintermedio.incidentes.utils;

import com.apintermedio.incidentes.requestDto.ServDto;

import java.util.List;
import java.util.Set;

public class ServicioUtils {
    public static ServDto unServicioDto(){
        return  new ServDto ( 5L, "aplicaciones" );
    }
    public static ServDto unServicio2(){
        return new ServDto ( 6L, "soporte tecnico" );
    }

    public static Set<ServDto> ListaServicioDto(){
        return Set.of(unServicioDto (), unServicio2 ());
    }
}
