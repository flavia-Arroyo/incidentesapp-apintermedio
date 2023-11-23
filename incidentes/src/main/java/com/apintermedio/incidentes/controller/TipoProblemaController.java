package com.apintermedio.incidentes.controller;

import com.apintermedio.incidentes.entity.TipoProblema;
import com.apintermedio.incidentes.service.ITipoProblemaService;
import com.apintermedio.incidentes.service.TipoProblemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidentes-app")
@CrossOrigin(value= "http://localhost:4200")
public class TipoProblemaController {
    @Autowired
    TipoProblemaService problemaService;
    //private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );
    @PostMapping("/problemas")
    public String crearProblema (@RequestBody TipoProblema problema){
        return problemaService.guardarProblema ( problema );
    }
    @GetMapping("/problemas")
    public List<TipoProblema>  traerProblemas(){
       List<TipoProblema> listProblema =  problemaService.listarProblema ();
        //listProblema.forEach ( problema-> logger.info(problema.toString ()) );
        return listProblema;
    }

    @DeleteMapping("/eliminarEspe/{idProblema}/{idEspe}")
    public String eliminarEspecialidad(@PathVariable long idProblema,
                                       @PathVariable long idEspe){
        return problemaService.eliminarEspecialidad ( idProblema, idEspe);

    }



}
