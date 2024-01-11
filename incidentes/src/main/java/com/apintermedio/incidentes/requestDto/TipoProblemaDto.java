package com.apintermedio.incidentes.requestDto;


import com.apintermedio.incidentes.enumerados.Complegidad;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoProblemaDto {
    private Long idTipoProblema;
    private String descripcionProblema;
    private Complegidad complegidad;
    private Integer horasMaximaResolucion;
    private List<EspecialidadDto> listaEspecialidades;
}
