package com.apintermedio.incidentes.responseDto;

import com.apintermedio.incidentes.entity.Incidente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString
public class NotificacionDto {




    private String mensaje;
}
