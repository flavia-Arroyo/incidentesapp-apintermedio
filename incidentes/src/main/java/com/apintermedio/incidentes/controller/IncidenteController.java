package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.entity.Tecnico;
import com.apintermedio.incidentes.requestDto.IncidenteDto;
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

    @Autowired
    IncidenteService incidenteService;

    @GetMapping("/incidentes")
    public List<Incidente> traerIncidente(){
        return incidenteService.listarIncidentes ();
    }

    @PostMapping("/incidente")
    public ResponseEntity<?> generarIncidente(@RequestBody IncidenteDto incidente){


        return new ResponseEntity<> ( incidenteService.guardarIncidente ( incidente ), HttpStatus.OK);
    }
}
