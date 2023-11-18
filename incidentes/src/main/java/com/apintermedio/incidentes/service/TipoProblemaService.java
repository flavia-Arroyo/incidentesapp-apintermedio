package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.repository.ITipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProblemaService implements ITipoProblemaService{
    @Autowired
    ITipoProblemaRepository problemaRepo;
    @Autowired
    IEspecialidadTecRepository espeRepo;
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

    @Override
    public TipoProblema asignarEspecialidad(Long idProblema, Long idEspe) {
        TipoProblema prob = problemaRepo.findById ( idProblema ).orElse ( null );
       EspecialidadTecnico espe = espeRepo.findById ( idEspe ).orElse ( null );
       prob.asignarEspecialidad ( espe );

        problemaRepo.save ( prob);
        return prob;



    }

    @Override
    public String eliminarEspecialidad(Long idProblema, Long idEspe) {
        TipoProblema prob = problemaRepo.findById ( idProblema ).orElse ( null );
        EspecialidadTecnico espe = espeRepo.findById ( idEspe ).orElse ( null );
        prob.borrarEspecialidad ( espe );

        problemaRepo.save ( prob );
        return "se elimino la especialidad correctamente";
    }

    @Override
    public TipoProblema asignarHoraMaxima(Long idProblema) {
        TipoProblema problema = this.buscarProblemaporId ( idProblema );
        problema.asignarHoraMaxima ( problema );
        this.guardarProblema ( problema );
        return problema;
    }
}
