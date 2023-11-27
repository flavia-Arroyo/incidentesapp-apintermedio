package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.repository.IServicioRepository;
import com.apintermedio.incidentes.requestDto.ServDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServicioService implements IServicioService{
    @Autowired
    IServicioRepository servRepo;
    @Override
    public List<ServDto> listarServicios() {

        ModelMapper mapper = new ModelMapper ();
        List<Servicios> listServicio =servRepo.findAll ();
        List<ServDto> listServDto = new ArrayList<> (  );
        listServicio.stream ().forEach ( s -> listServDto.add(mapper.map(s, ServDto.class)) );
        return listServDto;
    }


}
