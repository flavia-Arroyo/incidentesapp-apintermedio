package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.requestDto.TipoProblemaDto;
import com.apintermedio.incidentes.service.ITipoProblemaService;
import com.apintermedio.incidentes.service.TipoProblemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")

public class TipoProblemaController {
    @Autowired
    TipoProblemaService problemaService;

    @PostMapping("/problemas")
    public ResponseEntity<?> crearProblema (@RequestBody TipoProblemaDto problema){
        return new ResponseEntity<> (problemaService.guardarProblema ( problema ), HttpStatus.OK );
    }
    @GetMapping("/problemas")
    public ResponseEntity<?> traerProblemas(){

        return new ResponseEntity<> (  problemaService.listarProblema (), HttpStatus.OK);
    }








}
