package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoAsignado;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoDto;

import java.time.LocalTime;
import java.util.List;

public interface ITecnicoService {
    public List<TecnicoDto> listarTecnicos();
    public Tecnico buscarTecnicoporId(Long idTecnico);
    public ResponseTecnicoDto guardarTecnico(TecnicoDto tecnico);
    public void eliminarTecnicoporID(Long idTecnico);

    public ResponseTecnicoAsignado solucionarIncidente(IncidenteDto incidenteDto);





}
