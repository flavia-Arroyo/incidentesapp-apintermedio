package com.apintermedio.incidentes.service;


import com.apintermedio.incidentes.entity.Servicios;

import java.util.List;

public interface IServicioService {
    public List<Servicios> listarServicios();
    public Servicios buscarServiciosporId(Long idServicio);
    public void guardarServicio(Servicios servicio);
    public void eliminarServicioporID(Long idServicio);
}
