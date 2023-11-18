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
    private static final Logger logger = LoggerFactory.getLogger ( ClienteController.class );
    @PutMapping("/problema/{idProblema}/{idEspe}")
    public TipoProblema asignarEspecialidad(@PathVariable long idProblema,
                                            @PathVariable long idEspe){
        TipoProblema tipoProb =problemaService.asignarEspecialidad ( idProblema, idEspe );
        return tipoProb;
    }
    @GetMapping("/problemas")
    public List<TipoProblema>  traerProblemas(){
       List<TipoProblema> listProblema =  problemaService.listarProblema ();
        listProblema.forEach ( problema-> logger.info(problema.toString ()) );
        return listProblema;
    }

    @DeleteMapping("/eliminarEspe/{idProblema}/{idEspe}")
    public String eliminarEspecialidad(@PathVariable long idProblema,
                                       @PathVariable long idEspe){
        return problemaService.eliminarEspecialidad ( idProblema, idEspe);

    }
    @PutMapping("/asignarHoraMaxima/{idProblema}")
    public TipoProblema asignarMaximoHoras (@PathVariable long idProblema){
        return problemaService.asignarHoraMaxima ( idProblema );

    }


}
