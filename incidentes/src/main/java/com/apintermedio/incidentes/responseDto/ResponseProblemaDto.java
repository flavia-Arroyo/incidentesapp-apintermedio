package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.TipoProblemaDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ResponseProblemaDto {
    private Set<TipoProblemaDto> tipoProblema;
    private String mensaje;
}
