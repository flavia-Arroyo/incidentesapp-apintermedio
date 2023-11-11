package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listarClientes();
    public Cliente buscarClienteporId(Long idCliente);
    public void guardarCliente(Cliente cliente);
    public void eliminarClienteporID(Long idCliente);




}
