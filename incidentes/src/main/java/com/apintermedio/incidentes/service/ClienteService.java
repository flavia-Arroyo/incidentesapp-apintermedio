package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository cliRepo;
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listaCliente = cliRepo.findAll ();

        return listaCliente;
    }

    @Override
    public Cliente buscarClienteporId(Long idCliente) {
        Cliente cliente = cliRepo.findById ( idCliente ).orElse ( null );
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        cliRepo.save ( cliente );

    }

    @Override
    public void eliminarClienteporID(Long idCliente) {
        cliRepo.deleteById ( idCliente );

    }
}
