package com.apintermedio.incidentes.requestDto;



import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TecnicoDto {
    private Long tecnicoId;
    private String nombreCompleto;
    private String email;
    private Set<EspecialidadDto> listaEspecialidades;
}
