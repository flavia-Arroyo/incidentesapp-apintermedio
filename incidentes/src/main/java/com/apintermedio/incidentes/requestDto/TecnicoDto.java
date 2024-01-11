package com.apintermedio.incidentes.requestDto;



import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TecnicoDto {
    private Long tecnicoId;
    private String nombreCompleto;
    private String email;
    private Set<EspecialidadDto> listaEspecialidades;
}
