package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.requestDto.EspecialidadDto;
import com.apintermedio.incidentes.responseDto.ResponseEspeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Service
public class EspecialidadService implements IEspecialidadService{
    @Autowired
    IEspecialidadTecRepository espeRepo;
    @Override
    public List<EspecialidadDto> listarEspecialidad() {
        ModelMapper modelMapper = new ModelMapper ();
        List<EspecialidadTecnico> espePersist = espeRepo.findAll ();
        List<EspecialidadDto> espeDto = new ArrayList<> ();

        espePersist.stream ().forEach ( e -> espeDto.add(modelMapper.map(e, EspecialidadDto.class)));
        return  espeDto;
    }

    @Override
    public EspecialidadTecnico buscarEspecialidadporId(Long idEspecialidad) {
        return espeRepo.findById ( idEspecialidad ).orElse ( null );
    }

    @Override
    public ResponseEspeDto guardarEspecialidad(EspecialidadDto especialidad) {
        ModelMapper modelMapper = new ModelMapper ();
        EspecialidadTecnico espe = modelMapper.map(especialidad, EspecialidadTecnico.class);
        espe.getListaTecnicos ().forEach ( i -> i.setListaEspecialidades ( singleton (espe) ) );
        espe.getTipoProblema ().forEach ( i -> i.setListaEspecialidades ( (List<EspecialidadTecnico>) Collections.singleton (espe) ) );

        EspecialidadTecnico persistEspe = espeRepo.save ( espe );

        ResponseEspeDto res = new ResponseEspeDto ();
        res.setEspe ( modelMapper.map(persistEspe, (Type) EspecialidadDto.class ) );
        res.setMensaje ( "se guardo la especialidad correctamente" );


        return res;



    }

    @Override
    public void eliminarEspecialidadporID(Long idEspecialidad) {
        espeRepo.deleteById ( idEspecialidad );

    }
}
