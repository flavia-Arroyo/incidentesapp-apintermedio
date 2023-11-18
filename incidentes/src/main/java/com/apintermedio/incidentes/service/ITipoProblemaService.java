package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.TipoProblema;

import java.util.List;

public interface ITipoProblemaService {
    public List<TipoProblema> listarProblema();
    public TipoProblema buscarProblemaporId(Long idProblema);
    public void guardarProblema(TipoProblema tipoProblema);
    public void eliminarProblemaporID(Long idProblema);
    public TipoProblema asignarEspecialidad(Long idProblema, Long idEspe);
    public String eliminarEspecialidad(Long idProblema, Long idEspe);
    public TipoProblema asignarHoraMaxima(Long idProblema);
}
