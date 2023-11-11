package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class ClienteController {
    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );

    @Autowired
    private ClienteService cliServ;


    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = cliServ.listarClientes ();
        logger.info("Clientes obtenidos");
        clientes.forEach ( cliente -> logger.info(cliente.toString ()) );
        return clientes;
    }
    @PostMapping("/crearCliente")
    public String crearCliente(@RequestBody Cliente cli){
        cliServ.guardarCliente (cli  );
        return "El cliente fue creado correctamente";
    }



}
