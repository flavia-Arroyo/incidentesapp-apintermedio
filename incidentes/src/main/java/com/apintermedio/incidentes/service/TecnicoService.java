package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.repository.ITecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void guardarTecnico(Tecnico tecnico) {
           tecnicoRepo.save ( tecnico );
    }

    @Override
    public void eliminarTecnicoporID(Long idTecnico) {
        tecnicoRepo.deleteById ( idTecnico );

    }




}
