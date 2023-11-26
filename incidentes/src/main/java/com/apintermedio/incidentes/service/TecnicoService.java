package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.enumerados.Complegidad;
import com.apintermedio.incidentes.enumerados.Estados;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.repository.IIncidenteRepository;
import com.apintermedio.incidentes.repository.ITecnicoRepository;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoAsignado;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class TecnicoService implements ITecnicoService{
    @Autowired
    ITecnicoRepository tecnicoRepo;
    @Autowired
    IIncidenteRepository inciRepo;
    @Override
    public List<Tecnico> listarTecnicos() {
        return tecnicoRepo.findAll ();
    }

    @Override
    public Tecnico buscarTecnicoporId(Long idTecnico) {
        return tecnicoRepo.findById ( idTecnico ).orElse ( null );
    }

    @Override
    public ResponseTecnicoDto guardarTecnico(TecnicoDto tecnico) {

        ModelMapper modelMapper = new ModelMapper ();
        Tecnico tec = modelMapper.map(tecnico, Tecnico.class);
        tec.getListaEspecialidades ().forEach ( i -> i.setListaTecnicos ( Collections.singleton ( tec ) ) );
        Tecnico persistTecnico = tecnicoRepo.save ( tec );
        ResponseTecnicoDto resDto = new ResponseTecnicoDto ();
        resDto.setListTecnico ( Collections.singleton ( modelMapper.map ( persistTecnico, TecnicoDto.class ) ) );
        resDto.setMensaje ( "se guardo correctamente el tecnico" );



        return resDto;
    }

    @Override
    public void eliminarTecnicoporID(Long idTecnico) {
        tecnicoRepo.deleteById ( idTecnico );

    }

    @Override
    public ResponseTecnicoAsignado solucionarIncidente(IncidenteDto incidenteDto) {
        ModelMapper modelMapper = new ModelMapper ();
        Incidente inci = modelMapper.map(incidenteDto, Incidente.class);
        Set<TipoProblema> tipoProb = inci.getTipoProblema ();
        for(TipoProblema prob: tipoProb){
            if(prob.getComplegidad ().equals ( Complegidad.MEDIA )){
                inci.setHoraEstimadaTecnico (inci.getHoraIncidente ().plusHours ( 20 ));

            }
        }


        //se marca el incidente como resuelto
        inci.setEstado ( Estados.CERRADO );

        ResponseTecnicoAsignado resTecnico = new ResponseTecnicoAsignado ();

        inciRepo.save ( inci );



        resTecnico.setConsideraciones ( "se soluciono el incidente establecido en el tiempo establecido" );

        return resTecnico;
    }


}
