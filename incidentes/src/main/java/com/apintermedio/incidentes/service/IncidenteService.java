package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.repository.IIncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteService implements IIncidenteService{
    @Autowired
    IIncidenteRepository incidenteRepo;
    @Override
    public List<Incidente> listarIncidentes() {
        return incidenteRepo.findAll ();
    }

    @Override
    public Incidente buscarIncidenteporId(Long idIncidente) {
        return incidenteRepo.findById ( idIncidente ).orElse ( null );
    }

    @Override
    public void guardarIncidente(Incidente incidente) {

        incidenteRepo.save ( incidente );
    }

    @Override
    public void eliminarIncidenteporID(Long idIncidente) {
        incidenteRepo.deleteById ( idIncidente );

    }
}
