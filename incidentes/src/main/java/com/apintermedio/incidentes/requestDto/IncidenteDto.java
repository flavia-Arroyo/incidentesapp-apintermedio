package com.apintermedio.incidentes.requestDto;


import com.apintermedio.incidentes.enumerados.Estados;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
public class IncidenteDto {
    private Long incidenteId;
    private String descripcionProblema;
    private LocalDate fechaIncidente;
    private Estados estado;
    private LocalTime horaIncidente;
    private LocalTime horaEstimadaTecnico;
    private LocalDateTime fechaHoraTerminara;
    private ClienteDto cliente;
    private TecnicoDto tecnico;
     private Set<TipoProblemaDto> tipoProblema;
}
