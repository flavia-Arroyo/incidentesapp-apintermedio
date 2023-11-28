package com.apintermedio.incidentes.service;

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
import com.apintermedio.incidentes.responseDto.ResponseTecnicoAsignado;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TecnicoService implements ITecnicoService{
    @Autowired
    ITecnicoRepository tecnicoRepo;
    @Autowired
    IIncidenteRepository inciRepo;


    private static void accept(TipoProblema t) {
        t.getListaEspecialidades ( ).toArray ( );
    }

    @Override
    public List<TecnicoDto> listarTecnicos() {

        List<Tecnico> tecnicoPersis =  tecnicoRepo.findAll ();
        List<TecnicoDto>listTecnicoDto = new ArrayList<> ();
        ModelMapper modelMapper = new ModelMapper ();

        tecnicoPersis.stream ().forEach ( t -> listTecnicoDto.add(modelMapper.map(t, TecnicoDto.class)));
        return listTecnicoDto;

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

        inciRepo.save ( inci );

        ResponseTecnicoAsignado resTecnico = new ResponseTecnicoAsignado ();

        resTecnico.setConsideraciones ( "se soluciono el incidente establecido en el tiempo establecido" );

        return resTecnico;
    }




}
