package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.EspecialidadTecnico;
import com.apintermedio.incidentes.requestDto.EspecialidadDto;
import com.apintermedio.incidentes.service.EspecialidadService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")

public class EspecialidadController {


    @Autowired
    EspecialidadService espeService;

    @GetMapping("/especialidad")
    public ResponseEntity<?> traerEspecialidad(){


        return new ResponseEntity<> (  espeService.listarEspecialidad (), HttpStatus.OK);
    }
    @PostMapping("/especialidad")
    public ResponseEntity<?> crearEspecialidad(@RequestBody EspecialidadDto espe){


        return new ResponseEntity<> ( espeService.guardarEspecialidad ( espe ), HttpStatus.OK );
    }


}
