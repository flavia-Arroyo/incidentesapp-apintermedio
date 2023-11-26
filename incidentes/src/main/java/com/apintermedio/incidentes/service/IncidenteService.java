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
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class IncidenteService implements IIncidenteService{
    @Autowired
    IIncidenteRepository incidenteRepo;
    @Autowired
    TipoProblemaService proServ;
    @Autowired
   ITecnicoRepository tecnoRepo;

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

      //obtengo la primera diferencia de dias
       Incidente inciPrimero =  listIncidente.get ( 0 );
       fechaIncidente = inciPrimero.getFechaIncidente ();
       fechaTermina = inciPrimero.getFechaHoraTerminara ( ).toLocalDate ();
       diferencia = Period.between ( fechaIncidente, fechaTermina );
       diferenciaDias = diferencia.getDays ();
       menorDiferencia = diferenciaDias;
       tecnico  = inciPrimero.getTecnico ();

       for(Incidente inci:listIncidente){
           fechaIncidente = inci.getFechaIncidente ();
           fechaTermina = inci.getFechaHoraTerminara ().toLocalDate ();
           diferencia = Period.between ( fechaIncidente,fechaTermina );
           diferenciaDias = diferencia.getDays ();
           if(diferenciaDias < menorDiferencia) {
               menorDiferencia = diferenciaDias;
               tecnico = inci.getTecnico ( );
           }

       }



       
        ModelMapper modelMapper = new ModelMapper ();
       TecnicoDto tec = modelMapper.map(tecnico, TecnicoDto.class);
        return tec;
    }

    @Override
    public TecnicoDto tecnicoMasIncidentes(Integer dias) {
        //considerar la fecha actual como si fuera en 7 dias posterior para
        // que me traiga los incidentes
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaTerminaIncidente;
        LocalDate fechalimite;
        // Adelantar la fecha actual por 7 días SI HOY ES 26  SERIA 2 DICIEMBRE
        LocalDate fechaAdelantada = fechaActual.plus(7, ChronoUnit.DAYS);
        List<Incidente> listIncidente = incidenteRepo.findAll ();
        List<Integer> idTecnicos = new ArrayList<> ();
        for(Incidente inci:listIncidente){
            if(inci.getEstado () == Estados.CERRADO){
                fechalimite = fechaAdelantada.minus ( dias, ChronoUnit.DAYS );
                fechaTerminaIncidente = inci.getFechaHoraTerminara ().toLocalDate ();
                if(fechaTerminaIncidente.isAfter ( fechalimite )){
                    idTecnicos.add(inci.getTecnico ().getTecnicoId ().intValue ());
                }

            }
        }
        // Mapa para almacenar la frecuencia de cada elemento
        Map<Integer, Integer> frecuenciaMapa = new HashMap<>();
        for(Integer idTecnico: idTecnicos){
            frecuenciaMapa.put(idTecnico, frecuenciaMapa.getOrDefault(idTecnico, 0) + 1);

        }
        // Encontrar el elemento con la frecuencia máxima
        int elementoRepetido = -1;
        int frecuenciaMaxima = 0;

        for (Map.Entry<Integer, Integer> entry : frecuenciaMapa.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                frecuenciaMaxima = entry.getValue();
                elementoRepetido = entry.getKey();
            }
        }
        Long idTecnicoMasRepetido = (long) elementoRepetido;


       Tecnico tecRepo = tecnoRepo.findById ( idTecnicoMasRepetido ).orElse ( null );

        ModelMapper modelMapper = new ModelMapper ();
        TecnicoDto tec = modelMapper.map(tecRepo, TecnicoDto.class);
        return tec;




    }

}
