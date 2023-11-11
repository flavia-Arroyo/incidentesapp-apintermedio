package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.repository.ITipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProblemaService implements ITipoProblemaService{
    @Autowired
    ITipoProblemaRepository problemaRepo;
    @Override
    public List<TipoProblema> listarProblema() {
        return problemaRepo.findAll ();
    }

    @Override
    public TipoProblema buscarProblemaporId(Long idProblema) {
        return problemaRepo.findById ( idProblema ).orElse ( null );
    }

    @Override
    public void guardarProblema(TipoProblema tipoProblema) {
        problemaRepo.save ( tipoProblema );

    }

    @Override
    public void eliminarProblemaporID(Long idProblema) {
        problemaRepo.deleteById ( idProblema );

    }
}
