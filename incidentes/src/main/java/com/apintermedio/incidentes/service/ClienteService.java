package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.repository.IClienteRepository;
import com.apintermedio.incidentes.repository.IServicioRepository;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository cliRepo;
    @Autowired
    IServicioRepository servRepo;
    @Override
    public List<ClienteDto> listarClientes() {
        ModelMapper mapper = new ModelMapper ();

        List<Cliente> listaCliente = cliRepo.findAll ();
        List<ClienteDto> clienteDtoList = new ArrayList<> ();
        listaCliente.stream ().forEach ( c -> clienteDtoList.add(mapper.map(c, ClienteDto.class)) );

        return clienteDtoList;
    }

    @Override
    public Cliente buscarClienteporId(Long idCliente) {
        Cliente cliente = cliRepo.findById ( idCliente ).orElse ( null );
        return cliente;
    }

    @Override
    public ResponseClienteDto guardarCliente(ClienteDto cliente) {
        ModelMapper modelMapper = new ModelMapper ();
        Cliente cli = modelMapper.map(cliente, Cliente.class);

        cli.getListaServicios ().forEach ( i->i.setClientes ( Collections.singleton ( cli ) ) );


        Cliente persistCliente = cliRepo.save ( cli);
        ResponseClienteDto resDto = new ResponseClienteDto ();
        resDto.setCliente (modelMapper.map(persistCliente, ClienteDto.class)  );
        resDto.setMessage ( "Se guardo correctamente" );

         return resDto;
    }

    @Override
    public void eliminarClienteporID(Long idCliente) {
        cliRepo.deleteById ( idCliente );

    }


}
