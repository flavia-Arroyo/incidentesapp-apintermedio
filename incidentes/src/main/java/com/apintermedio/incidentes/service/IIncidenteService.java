package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.Incidente;

import java.util.List;

public interface IIncidenteService {
    public List<Incidente> listarIncidentes();
    public Incidente buscarIncidenteporId(Long idIncidente);
    public void guardarIncidente(Incidente incidente);
    public void eliminarIncidenteporID(Long idIncidente);

}
