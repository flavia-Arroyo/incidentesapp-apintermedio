package com.apintermedio.incidentes.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemasDto {
    List<TipoProblemaDto> listProblemas;
}
