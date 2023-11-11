package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.EspecialidadTecnico;

import java.util.List;

public interface IEspecialidadService {

    public List<EspecialidadTecnico> listarEspecialidad();
    public EspecialidadTecnico buscarEspecialidadporId(Long idEspecialidad);
    public void guardarEspecialidad(EspecialidadTecnico especialidad);
    public void eliminarEspecialidadporID(Long idEspecialidad);
}
