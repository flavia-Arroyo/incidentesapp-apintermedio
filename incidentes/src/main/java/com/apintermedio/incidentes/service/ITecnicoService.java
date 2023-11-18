package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Tecnico;

import java.util.List;

public interface ITecnicoService {
    public List<Tecnico> listarTecnicos();
    public Tecnico buscarTecnicoporId(Long idTecnico);
    public void guardarTecnico(Tecnico tecnico);
    public void eliminarTecnicoporID(Long idTecnico);
    public Tecnico asignarEspecialidad(Long idTecnico, Long idEspecialidad);
}
