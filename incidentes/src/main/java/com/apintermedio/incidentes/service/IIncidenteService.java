package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseIncideteDto;

import java.util.List;

public interface IIncidenteService {
    public List<IncidenteDto> listarIncidentes();
    public Incidente buscarIncidenteporId(Long idIncidente);
    public ResponseIncideteDto guardarIncidente(IncidenteDto incidente);
    public void eliminarIncidenteporID(Long idIncidente);
    public TecnicoDto tecnicoMasEficiente();
    public TecnicoDto tecnicoMasIncidentes(Integer dias);


    public TecnicoDto tecnicoPorDiaPorEspe(Integer dias, String especialidad);
}
