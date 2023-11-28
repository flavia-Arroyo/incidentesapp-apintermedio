package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.requestDto.TipoProblemaDto;
import com.apintermedio.incidentes.responseDto.ResponseProblemaDto;

import java.util.List;

public interface ITipoProblemaService {
    public List<TipoProblemaDto> listarProblema();
    public TipoProblema buscarProblemaporId(Long idProblema);
    public ResponseProblemaDto guardarProblema(TipoProblemaDto tipoProblema);


}
