package com.apintermedio.incidentes.service;

import com.apintermedio.incidentes.entity.Cliente;
import com.apintermedio.incidentes.entity.Servicios;
import com.apintermedio.incidentes.exception.ClienteNotFoundException;
import com.apintermedio.incidentes.exception.ClonException;
import com.apintermedio.incidentes.exception.InsertionDbException;
import com.apintermedio.incidentes.repository.IClienteRepository;
import com.apintermedio.incidentes.repository.IServicioRepository;
import com.apintermedio.incidentes.requestDto.ClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseClienteDto;
import com.apintermedio.incidentes.responseDto.ResponseMensajeDto;
import org.apache.catalina.connector.ClientAbortException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if(listaCliente.isEmpty ()){
            throw new ClienteNotFoundException ( "La lista de clientes esta vacia" );
        }


        List<ClienteDto> clienteDtoList = new ArrayList<> ();
        listaCliente.stream ().forEach ( c -> clienteDtoList.add(mapper.map(c, ClienteDto.class)) );

        return clienteDtoList;
    }

    @Override
    public ClienteDto buscarClienteporId(Long idCliente) {
        ModelMapper mapper = new ModelMapper ();

        Cliente cliente = cliRepo.findById ( idCliente ).orElseThrow ( ()-> new ClienteNotFoundException ("No existe el Cliente buscado"));
        ClienteDto cliResponse = mapper.map(cliente, ClienteDto.class);
        return cliResponse;
    }

    @Override
    public ResponseClienteDto guardarCliente(ClienteDto cliente) {
        ModelMapper modelMapper = new ModelMapper ();
        Cliente cli = modelMapper.map(cliente, Cliente.class);
        if(verificarExistencia(cli)){
            throw new ClonException ( "El Cliente ya existe" );
        }

        cli.getListaServicios ().forEach ( i->i.setClientes ( Collections.singleton ( cli ) ) );

        Cliente persistCliente = cliRepo.save ( cli);
        if(persistCliente == null){
            throw new InsertionDbException ("No se guardo el cliente Correctamente"  );
        }
        ResponseClienteDto resDto = new ResponseClienteDto ();
        resDto.setCliente (modelMapper.map(persistCliente, ClienteDto.class)  );
        resDto.setMessage ( "Se guardo correctamente" );

         return resDto;
    }

    private boolean verificarExistencia(Cliente cli) {
       List<Cliente> listClientes = cliRepo.findAll ();
       if(listClientes.isEmpty ()){
           return false;
       }
       List<Cliente> cliBusqueda = listClientes.stream ()
               .filter ( c-> c.getRazonSocial ().equals ( cli.getRazonSocial () ) ).toList ();


        return !cliBusqueda.isEmpty ();
    }

    @Override
    public void eliminarClienteporID(Long idCliente) {
        cliRepo.deleteById ( idCliente );

    }

    @Override
    public ResponseMensajeDto borrarCliente(Long idCliente) {
        Optional<Cliente> cliente = cliRepo.findById(idCliente);
        cliente.ifPresent(value -> cliRepo.delete(value));
        return new ResponseMensajeDto ("Cliente eliminado con éxito");

    }


}
