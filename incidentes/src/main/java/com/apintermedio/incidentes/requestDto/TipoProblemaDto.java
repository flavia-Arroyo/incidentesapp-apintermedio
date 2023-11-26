package com.apintermedio.incidentes.requestDto;


import com.apintermedio.incidentes.enumerados.Complegidad;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoProblemaDto {
    private Long idTipoProblema;
    private String descripcionProblema;
    private Complegidad complegidad;
    private Integer horasMaximaResolucion;
    private List<EspecialidadDto> listaEspecialidades;
}
