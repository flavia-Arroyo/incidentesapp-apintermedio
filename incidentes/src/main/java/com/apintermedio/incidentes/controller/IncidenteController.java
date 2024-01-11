package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.service.IIncidenteService;
import com.apintermedio.incidentes.service.IncidenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")

public class IncidenteController {

   // @Autowired
    //IncidenteService incidenteService;
    //con el constructor
    private IIncidenteService incidenteService;

    public IncidenteController(IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }

    @GetMapping("/incidentes")
    public ResponseEntity<?> traerIncidente(){

        return new ResponseEntity<> (incidenteService.listarIncidentes (), HttpStatus.OK  ) ;
    }

    @PostMapping("/incidente")
    public ResponseEntity<?> generarIncidente(@RequestBody IncidenteDto incidente){


        return new ResponseEntity<> ( incidenteService.guardarIncidente ( incidente ), HttpStatus.OK);
    }
    @GetMapping("/tecnicoMasEficiente")
    public ResponseEntity<?> traerTecnico(){
        return new ResponseEntity<> ( incidenteService.tecnicoMasEficiente(), HttpStatus.OK );
    }
    @GetMapping("/tecnicoMasIncidentesResueltos/{dias}")
    public ResponseEntity<?> traerTecnico(@PathVariable Integer dias){
        return new ResponseEntity<> ( incidenteService.tecnicoMasIncidentes(dias), HttpStatus.OK );
    }
    @GetMapping("/tecnicoMasResolucionesPorEspecialidad/{dias}/{especialidad}")
    public ResponseEntity<?> traerTecnicoEspe(@PathVariable Integer dias,
                                              @PathVariable String especialidad){
        return new ResponseEntity<> ( incidenteService.tecnicoPorDiaPorEspe(dias, especialidad), HttpStatus.OK );
    }

}
