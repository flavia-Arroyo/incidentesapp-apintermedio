package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspecialidadService implements IEspecialidadService{
    @Autowired
    IEspecialidadTecRepository espeRepo;
    @Override
    public List<EspecialidadTecnico> listarEspecialidad() {
        return espeRepo.findAll ();
    }

    @Override
    public EspecialidadTecnico buscarEspecialidadporId(Long idEspecialidad) {
        return espeRepo.findById ( idEspecialidad ).orElse ( null );
    }

    @Override
    public void guardarEspecialidad(EspecialidadTecnico especialidad) {
        espeRepo.save ( especialidad );

    }

    @Override
    public void eliminarEspecialidadporID(Long idEspecialidad) {
        espeRepo.deleteById ( idEspecialidad );

    }
}
