package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.IncidenteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TecnicoPorProblemas {
    private Long tecnicoId;
    private String nombreCompleto;
    private Integer cantIncidentes;
}
