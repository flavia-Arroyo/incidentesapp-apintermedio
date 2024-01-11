package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.requestDto.IncidenteDto;
import com.apintermedio.incidentes.requestDto.ProblemasDto;
import com.apintermedio.incidentes.requestDto.TecnicoDto;
import com.apintermedio.incidentes.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("incidentes-app")

public class TecnicoController {

    @Autowired
    ITecnicoService tecnicoServ;
    @PostMapping("/crearTecnico")
    public ResponseEntity<?> crearTecnico(@RequestBody TecnicoDto tecnico){

        return new ResponseEntity<> ( tecnicoServ.guardarTecnico ( tecnico ), HttpStatus.OK );
    }
    @PutMapping ("/tecnicoAsignado")
    public ResponseEntity<?> traerTecnicos(@RequestBody IncidenteDto incidenteDto){

        return new ResponseEntity<> ( tecnicoServ.solucionarIncidente(incidenteDto) ,HttpStatus.OK);
    }

    @GetMapping("/tecnicoDisponibles")
    public ResponseEntity<?> traerTecnicosPorProblema(@RequestBody ProblemasDto problemas){
        System.out.println ("lo requerido " + problemas );
        return new ResponseEntity<> ( tecnicoServ.buscarTecnicos ( problemas ), HttpStatus.OK );
    }


    @GetMapping("/tecnicos")
    public ResponseEntity<?> traerTecnicos(){
        return new ResponseEntity<> ( tecnicoServ.listarTecnicos (), HttpStatus.OK );
    }





}
