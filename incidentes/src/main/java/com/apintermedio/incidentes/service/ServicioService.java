package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioService implements IServicioService{
    @Autowired
    IServicioRepository servRepo;
    @Override
    public List<Servicios> listarServicios() {
        return servRepo.findAll ();
    }

    @Override
    public Servicios buscarServiciosporId(Long idServicio) {
        return servRepo.findById ( idServicio ).orElse ( null );
    }

    @Override
    public void guardarServicio(Servicios servicio) {
        servRepo.save ( servicio );

    }

    @Override
    public void eliminarServicioporID(Long idServicio) {
        servRepo.deleteById ( idServicio );

    }
}
