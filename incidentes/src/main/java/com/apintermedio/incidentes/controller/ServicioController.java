package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.service.ServicioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class ServicioController {

    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );
    @Autowired
    private ServicioService servServicio;
    @GetMapping("/servicios")
    public List<Servicios> obtenerServicios(){
        List<Servicios> listaServ = servServicio.listarServicios ();

        return listaServ;

    }

}
