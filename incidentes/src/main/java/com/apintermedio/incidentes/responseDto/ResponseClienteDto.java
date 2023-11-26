package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.ClienteDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseClienteDto {
    private ClienteDto cliente;

    private String message;
}
