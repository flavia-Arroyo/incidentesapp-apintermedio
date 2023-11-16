package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.TipoProblema;

import java.util.List;

public interface ITipoProblemaService {
    public List<TipoProblema> listarProblema();
    public TipoProblema buscarProblemaporId(Long idProblema);
    public void guardarProblema(TipoProblema tipoProblema);
    public void eliminarProblemaporID(Long idProblema);
}