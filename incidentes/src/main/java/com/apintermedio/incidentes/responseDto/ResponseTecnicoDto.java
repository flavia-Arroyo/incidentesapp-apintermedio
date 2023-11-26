package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.TecnicoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ResponseTecnicoDto {
    private Set<TecnicoDto> listTecnico;
    private String mensaje;
}
