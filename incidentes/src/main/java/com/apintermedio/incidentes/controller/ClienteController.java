package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
//@CrossOrigin(value= "http://localhost:4200")
public class ClienteController {
    //private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );

    @Autowired
    private ClienteService cliServ;


    @GetMapping("/clientes")
    public ResponseEntity<?>obtenerClientes(){
        List<ClienteDto> clientes = cliServ.listarClientes ();

        return new ResponseEntity<> ( cliServ.listarClientes (), HttpStatus.OK );
    }
    @PostMapping("/crearCliente")
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDto cli){

        return new ResponseEntity<> ( cliServ.guardarCliente ( cli ), HttpStatus.OK );
    }




}
