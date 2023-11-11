package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Incidente;
import com.apintermedio.incidentes.service.IncidenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class IncidenteController {
    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );
    @Autowired
    IncidenteService incidenteService;

    @GetMapping("/incidentes")
    public List<Incidente> traerIncidente(){
        return incidenteService.listarIncidentes ();
    }

    @PostMapping("/incidente")
    public String crearIncidente(){

        return "el incidente ha sido creado";
    }
}
