package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.requestDto.ClienteDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseClienteDto {
    private ClienteDto cliente;

    private String message;
}
