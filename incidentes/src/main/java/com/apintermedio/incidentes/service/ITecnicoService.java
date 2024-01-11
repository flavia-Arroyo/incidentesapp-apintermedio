package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.ProblemasDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoAsignado;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoDto;
import com.apintermedio.incidentes.responseDto.TecnicoPorProblemas;

import java.util.List;
import java.util.Set;

public interface ITecnicoService {
    public List<TecnicoDto> listarTecnicos();
    public Tecnico buscarTecnicoporId(Long idTecnico);
    public ResponseTecnicoDto guardarTecnico(TecnicoDto tecnico);


    public ResponseTecnicoAsignado solucionarIncidente(IncidenteDto incidenteDto);
    public Set<TecnicoPorProblemas> buscarTecnicos(ProblemasDto problemas);



}
