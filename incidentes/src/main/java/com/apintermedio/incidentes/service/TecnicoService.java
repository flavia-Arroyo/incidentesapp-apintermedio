package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.repository.ITecnicoRepository;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.responseDto.ResponseTecnicoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TecnicoService implements ITecnicoService{
    @Autowired
    ITecnicoRepository tecnicoRepo;
    @Autowired
    IEspecialidadTecRepository espeRepo;
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




}
