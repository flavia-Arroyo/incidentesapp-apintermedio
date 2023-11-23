package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.enumerados.Estados;
import com.apintermedio.incidentes.repository.IIncidenteRepository;
import com.apintermedio.incidentes.repository.ITecnicoRepository;
import com.apintermedio.incidentes.repository.ITipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenteService implements IIncidenteService{
    @Autowired
    IIncidenteRepository incidenteRepo;
    @Autowired
    TipoProblemaService proServ;
    @Override
    public List<Incidente> listarIncidentes() {
        return incidenteRepo.findAll ();
    }

    @Override
    public Incidente buscarIncidenteporId(Long idIncidente) {
        return incidenteRepo.findById ( idIncidente ).orElse ( null );
    }

    @Override
    public String guardarIncidente(Incidente incidente) {
        incidente.determinarFecha ();
         incidente.horaIncidente ();
        incidente.setEstado ( Estados.ASIGNADO);
      //busco los problemas asignados al incidente
        List<TipoProblema>problema = incidente.getTipoProblema ();
        Integer horaProb = 0;
        Integer horaTotal = 0;
       for(TipoProblema prob: problema){
          Long idProb = prob.getIdTipoProblema ();
          TipoProblema proble = proServ.buscarProblemaporId ( idProb );
          horaProb = proble.getHorasMaximaResolucion ();
          horaTotal += horaProb;


       }

       incidente.setFechaHoraTerminara ( LocalDateTime.now (  ).plusHours ( horaTotal ) );

        incidenteRepo.save ( incidente );
        return "el incidente se creo correctamente " + "estará resuelto el dia : " + incidente.getFechaHoraTerminara ();
    }

    @Override
    public void eliminarIncidenteporID(Long idIncidente) {
        incidenteRepo.deleteById ( idIncidente );

    }

}
