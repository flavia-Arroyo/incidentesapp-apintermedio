package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.enumerados.Complegidad;
import com.apintermedio.incidentes.enumerados.Estados;
import com.apintermedio.incidentes.repository.IIncidenteRepository;
import com.apintermedio.incidentes.repository.ITecnicoRepository;
import com.apintermedio.incidentes.repository.ITipoProblemaRepository;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseIncideteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
public class IncidenteService implements IIncidenteService{
    @Autowired
    IIncidenteRepository incidenteRepo;
    @Autowired
    TipoProblemaService proServ;
    @Autowired
    TecnicoService tecnoServ;

    @Override
    public List<IncidenteDto> listarIncidentes() {
        ModelMapper mapper = new ModelMapper ();
        List<Incidente>incidenteEnt = incidenteRepo.findAll ();
        List<IncidenteDto> inciDto = new ArrayList<> ();
        incidenteEnt.stream ().forEach ( i -> inciDto.add(mapper.map(i, IncidenteDto.class)) );

        return inciDto;
    }

    @Override
    public Incidente buscarIncidenteporId(Long idIncidente) {
        return incidenteRepo.findById ( idIncidente ).orElse ( null );
    }

    @Override
    public ResponseIncideteDto guardarIncidente(IncidenteDto incidente) {

        ModelMapper modelMapper = new ModelMapper ();
        Incidente inci = modelMapper.map(incidente, Incidente.class);
        inci.determinarFecha ();
        inci.horaIncidente ();

        inci.getTipoProblema ().forEach ( i -> i.setListIncidente ( Collections.singleton ( inci ) ) );

      //busco los problemas asignados al incidente
        Set<TipoProblema> problema = inci.getTipoProblema ();

        Integer horaTotal = 0;
        Integer plusHorasPorComplejo = 0;


        //determino el tiempo maximo de resolucion del incidente
       for(TipoProblema prob: problema){
          Long idProb = prob.getIdTipoProblema ();
          TipoProblema proble = proServ.buscarProblemaporId ( idProb );

          horaTotal += proble.getHorasMaximaResolucion ();

           if(prob.getComplegidad ().equals ( Complegidad.ALTA )){
               //adiciono tiempo al tiempo maximo estipulado
               plusHorasPorComplejo = 24;
               horaTotal += plusHorasPorComplejo;
           }
       }

       inci.setFechaHoraTerminara ( LocalDateTime.now (  ).plusHours ( horaTotal ) );
       inci.setEstado ( Estados.ASIGNADO );



        Incidente persistInci = incidenteRepo.save ( inci );

        ResponseIncideteDto resDto = new ResponseIncideteDto ();
        resDto.setListIncidente ( Collections.singleton ( modelMapper.map ( persistInci,
                IncidenteDto.class )));
        resDto.setMensaje ( "el incidente se creo correctamente " + "estará resuelto el dia : " + inci.getFechaHoraTerminara () +
                "el tecnico " + inci.getTecnico ().getNombreCompleto () + "   tiene un nuevo incidente a resolver");

        return resDto;
    }

    @Override
    public void eliminarIncidenteporID(Long idIncidente) {
        incidenteRepo.deleteById ( idIncidente );

    }

    @Override
    public TecnicoDto tecnicoMasEficiente() {

        List<Incidente> listIncidente = incidenteRepo.findAll ();
      LocalDate fechaIncidente;
      LocalDate fechaTermina;
      Period diferencia;
      int menorDiferencia= 0;
      Tecnico tecnico = null;
      int diferenciaDias ;

       for(Incidente inci:listIncidente){
           fechaIncidente = inci.getFechaIncidente ();
           fechaTermina = inci.getFechaHoraTerminara ().toLocalDate ();
           diferencia = Period.between ( fechaIncidente,fechaTermina );
           diferenciaDias = diferencia.getDays ();

           menorDiferencia = diferenciaDias;
           tecnico = inci.getTecnico ();

          if(  diferenciaDias < menorDiferencia ){
              System.out.println ("la primera vez menorDirefencia" + menorDiferencia );
              System.out.println ("la primera vez la diferencia en dias" + diferenciaDias );
              menorDiferencia = diferenciaDias;
              tecnico = inci.getTecnico ();
          }



       }
        System.out.println ("queda menor diferencia " + menorDiferencia);


       
        ModelMapper modelMapper = new ModelMapper ();
       TecnicoDto tec = modelMapper.map(tecnico, TecnicoDto.class);
        return tec;
    }

}
