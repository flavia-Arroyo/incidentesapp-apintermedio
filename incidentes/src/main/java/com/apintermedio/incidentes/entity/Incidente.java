package com.apintermedio.incidentes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidenteId;
    private String descripcion;
    private LocalDate fechaNotificacion;
    private Boolean estado;
    @OneToMany
    private List<TipoProblema> tipoProblema;






}
