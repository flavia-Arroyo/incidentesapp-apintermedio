package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.responseDto.ResponseDto;
import com.apintermedio.incidentes.service.IIncidenteService;
import com.apintermedio.incidentes.service.ITecnicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class TecnicoController {
    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );
    @Autowired
    ITecnicoService tecnicoServ;
    @PostMapping("/crearTecnico")
    public String crearTecnico(@RequestBody Tecnico tecnico){

        tecnicoServ.guardarTecnico ( tecnico );
        return "El tecnico fue creado correctamente";
    }
}
