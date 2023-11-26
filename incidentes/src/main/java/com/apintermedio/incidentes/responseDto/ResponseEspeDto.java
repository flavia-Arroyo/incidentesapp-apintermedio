package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.EspecialidadDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ResponseEspeDto {
    private Set<EspecialidadDto>espe;
    private String mensaje;

}
