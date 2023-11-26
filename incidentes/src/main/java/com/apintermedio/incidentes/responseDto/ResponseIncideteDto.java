package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.IncidenteDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ResponseIncideteDto {
    private Set<IncidenteDto> listIncidente;
    private String mensaje;

}
