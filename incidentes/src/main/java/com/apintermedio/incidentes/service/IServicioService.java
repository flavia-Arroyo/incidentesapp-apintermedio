package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.requestDto.ServDto;

import java.util.List;

public interface IServicioService {
    public List<ServDto> listarServicios();

}
