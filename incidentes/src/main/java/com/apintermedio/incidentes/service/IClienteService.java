package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseMensajeDto;

import java.util.List;

public interface IClienteService {

    public List<ClienteDto> listarClientes();
    public Cliente buscarClienteporId(Long idCliente);
    public ResponseClienteDto guardarCliente(ClienteDto cliente);
    public void eliminarClienteporID(Long idCliente);
    public ResponseMensajeDto borrarCliente(Long idCliente);





}
