package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.requestDto.EspecialidadDto;
import com.apintermedio.incidentes.responseDto.ResponseEspeDto;

import java.util.List;

public interface IEspecialidadService {

    public List<EspecialidadTecnico> listarEspecialidad();
    public EspecialidadTecnico buscarEspecialidadporId(Long idEspecialidad);
    public ResponseEspeDto guardarEspecialidad(EspecialidadDto especialidad);
    public void eliminarEspecialidadporID(Long idEspecialidad);
}
