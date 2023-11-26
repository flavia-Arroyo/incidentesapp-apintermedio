package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.repository.IEspecialidadTecRepository;
import com.apintermedio.incidentes.repository.ITipoProblemaRepository;
import com.apintermedio.incidentes.requestDto.TipoProblemaDto;
import com.apintermedio.incidentes.responseDto.ResponseProblemaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public ResponseProblemaDto guardarProblema(TipoProblemaDto tipoProblema) {

        ModelMapper modelMapper = new ModelMapper ();

        TipoProblema tipoProb = modelMapper.map(tipoProblema, TipoProblema.class);
        tipoProb.asignarHoraMaxima ( tipoProb);
        tipoProb.getListaEspecialidades ().forEach ( i ->
                i.setTipoProblema ( Collections.singleton ( tipoProb ) ));


        TipoProblema persistProblema = problemaRepo.save ( tipoProb);
        ResponseProblemaDto resDto = new ResponseProblemaDto ();
        resDto.setTipoProblema ( Collections.singleton ( modelMapper.map ( persistProblema, TipoProblemaDto.class ) ) );
        resDto.setMensaje ( "se genero correctamente el tipo de problema" );
        return resDto;

    }

    @Override
    public void eliminarProblemaporID(Long idProblema) {
        problemaRepo.deleteById ( idProblema );

    }



    @Override
    public String eliminarEspecialidad(Long idProblema, Long idEspe) {
        TipoProblema prob = problemaRepo.findById ( idProblema ).orElse ( null );
        EspecialidadTecnico espe = espeRepo.findById ( idEspe ).orElse ( null );
        prob.borrarEspecialidad ( espe );

        problemaRepo.save ( prob );
        return "se elimino la especialidad correctamente";
    }


}
