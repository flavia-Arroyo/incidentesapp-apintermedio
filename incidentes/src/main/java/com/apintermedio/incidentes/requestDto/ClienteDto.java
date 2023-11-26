package com.apintermedio.incidentes.requestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class ClienteDto {
    private Long clienteId;
    private String razonSocial;
    private Long cuit;
    private String domicilio;
    private String email;
    private Set<ServDto> listaServicios;

}
