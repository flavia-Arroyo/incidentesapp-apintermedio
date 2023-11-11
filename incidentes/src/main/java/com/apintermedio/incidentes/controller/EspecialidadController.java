package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.service.EspecialidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class EspecialidadController {
    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );

    @Autowired
    EspecialidadService espeService;

    @GetMapping("/especialidad")
    public List<EspecialidadTecnico> traerEspecialidad(){

        return espeService.listarEspecialidad ();
    }

}
